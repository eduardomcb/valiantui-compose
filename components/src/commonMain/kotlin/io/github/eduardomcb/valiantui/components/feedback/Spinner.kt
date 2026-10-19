package io.github.eduardomcb.valiantui.components.feedback

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.eduardomcb.valiantui.theme.ValiantColorRole
import io.github.eduardomcb.valiantui.theme.ValiantTheme

enum class SpinnerSize(val size: Dp, val strokeWidth: Dp) {
    Sm(size = 16.dp, strokeWidth = 2.dp),
    Md(size = 20.dp, strokeWidth = 2.5.dp),
    Lg(size = 24.dp, strokeWidth = 3.dp)
}

@Composable
fun Spinner(
    modifier: Modifier = Modifier,
    size: SpinnerSize = SpinnerSize.Md,
    color: Color? = null,
    colorRole: ValiantColorRole = ValiantColorRole.Primary,
    trackColor: Color = Color.Transparent
) {
    val effectiveColor = color ?: ValiantTheme.colors.forRole(colorRole).color

    val transition = rememberInfiniteTransition(label = "spinnerTransition")
    val rotation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 800, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "spinnerRotation"
    )

    Canvas(
        modifier = modifier.size(size.size)
    ) {
        val stroke = size.strokeWidth.toPx()
        val diameter = this.size.minDimension - stroke
        val topLeft = Offset(stroke / 2f, stroke / 2f)
        val arcSize = Size(diameter, diameter)

        if (trackColor != Color.Transparent) {
            drawArc(
                color = trackColor,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                topLeft = topLeft,
                size = arcSize,
                style = Stroke(width = stroke)
            )
        }

        drawArc(
            color = effectiveColor,
            startAngle = rotation,
            sweepAngle = 270f,
            useCenter = false,
            topLeft = topLeft,
            size = arcSize,
            style = Stroke(width = stroke, cap = StrokeCap.Round)
        )
    }
}
