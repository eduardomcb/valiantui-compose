package io.github.eduardomcb.valiantui.components.feedback

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.eduardomcb.valiantui.theme.ValiantColorRole
import io.github.eduardomcb.valiantui.theme.ValiantTheme

/**
 * Size variants for Spinner matching HeroUI v3 specifications.
 * - [Sm]: size-4 (16dp)
 * - [Md]: size-6 (24dp) [Default]
 * - [Lg]: size-8 (32dp)
 * - [Xl]: size-10 (40dp)
 */
enum class SpinnerSize(val size: Dp, val strokeWidth: Dp) {
    Sm(size = 16.dp, strokeWidth = 2.dp),
    Md(size = 24.dp, strokeWidth = 2.5.dp),
    Lg(size = 32.dp, strokeWidth = 3.dp),
    Xl(size = 40.dp, strokeWidth = 3.5.dp)
}

/**
 * Semantic color variants for Spinner matching HeroUI v3.
 */
enum class SpinnerColor {
    Current,
    Accent,
    Success,
    Warning,
    Danger
}

@Composable
fun Spinner(
    modifier: Modifier = Modifier,
    size: SpinnerSize = SpinnerSize.Md,
    color: SpinnerColor = SpinnerColor.Accent,
    trackColor: Color = Color.Transparent,
    durationMillis: Int = 750
) {
    val effectiveColor = when (color) {
        SpinnerColor.Current -> LocalContentColor.current
        SpinnerColor.Accent -> ValiantTheme.colors.accent.color
        SpinnerColor.Success -> ValiantTheme.colors.success.color
        SpinnerColor.Warning -> ValiantTheme.colors.warning.color
        SpinnerColor.Danger -> ValiantTheme.colors.danger.color
    }

    SpinnerContent(
        modifier = modifier,
        size = size,
        color = effectiveColor,
        trackColor = trackColor,
        durationMillis = durationMillis
    )
}

@Composable
fun Spinner(
    color: Color,
    modifier: Modifier = Modifier,
    size: SpinnerSize = SpinnerSize.Md,
    trackColor: Color = Color.Transparent,
    durationMillis: Int = 750
) {
    SpinnerContent(
        modifier = modifier,
        size = size,
        color = color,
        trackColor = trackColor,
        durationMillis = durationMillis
    )
}

@Composable
fun Spinner(
    colorRole: ValiantColorRole,
    modifier: Modifier = Modifier,
    size: SpinnerSize = SpinnerSize.Md,
    trackColor: Color = Color.Transparent,
    durationMillis: Int = 750
) {
    SpinnerContent(
        modifier = modifier,
        size = size,
        color = ValiantTheme.colors.forRole(colorRole).color,
        trackColor = trackColor,
        durationMillis = durationMillis
    )
}

private const val SPINNER_PATH1_DATA =
    "M8.749.021a1.5 1.5 0 0 1 .497 2.958A7.5 7.5 0 0 0 3 10.375a7.5 7.5 0 0 0 7.5 7.5v3c-5.799 0-10.5-4.7-10.5-10.5C0 5.23 3.726.865 8.749.021"

private const val SPINNER_PATH2_DATA =
    "M15.392 2.673a1.5 1.5 0 0 1 2.119-.115A10.48 10.48 0 0 1 21 10.375c0 5.8-4.701 10.5-10.5 10.5v-3a7.5 7.5 0 0 0 5.007-13.084a1.5 1.5 0 0 1-.115-2.118"

@Composable
private fun SpinnerContent(
    modifier: Modifier = Modifier,
    size: SpinnerSize,
    color: Color,
    trackColor: Color,
    durationMillis: Int
) {
    val transition = rememberInfiniteTransition(label = "spinnerTransition")
    val rotation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = durationMillis, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "spinnerRotation"
    )

    val path1 = remember { PathParser().parsePathString(SPINNER_PATH1_DATA).toPath() }
    val path2 = remember { PathParser().parsePathString(SPINNER_PATH2_DATA).toPath() }

    val baseAlpha = color.alpha
    val brush1 = remember(color) {
        Brush.linearGradient(
            0.0f to color.copy(alpha = baseAlpha * 1.0f),
            1.0f to color.copy(alpha = baseAlpha * 0.55f),
            start = Offset(5.25f, 1.1016f),
            end = Offset(5.25f, 19.1847f)
        )
    }
    val brush2 = remember(color) {
        Brush.linearGradient(
            0.0f to color.copy(alpha = 0.0f),
            1.0f to color.copy(alpha = baseAlpha * 0.55f),
            start = Offset(15.75f, 5.05f),
            end = Offset(15.75f, 18.50f)
        )
    }

    Canvas(
        modifier = modifier.size(size.size)
    ) {
        val minDim = this.size.minDimension
        val scale = minDim / 24f
        val offsetX = (this.size.width - minDim) / 2f
        val offsetY = (this.size.height - minDim) / 2f
        val pivot = Offset(offsetX + 12f * scale, offsetY + 12.125f * scale)

        if (trackColor != Color.Transparent) {
            drawCircle(
                color = trackColor,
                radius = 9f * scale,
                center = pivot,
                style = Stroke(width = 3f * scale)
            )
        }

        rotate(degrees = rotation, pivot = pivot) {
            translate(left = offsetX, top = offsetY) {
                scale(scale = scale, pivot = Offset.Zero) {
                    translate(left = 1.5f, top = 1.625f) {
                        drawPath(path = path1, brush = brush1)
                        drawPath(path = path2, brush = brush2)
                    }
                }
            }
        }
    }
}
