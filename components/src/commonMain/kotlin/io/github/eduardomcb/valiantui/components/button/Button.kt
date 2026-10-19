package io.github.eduardomcb.valiantui.components.button

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.eduardomcb.valiantui.components.feedback.Spinner
import io.github.eduardomcb.valiantui.components.feedback.SpinnerSize
import io.github.eduardomcb.valiantui.interaction.pointerCursor
import io.github.eduardomcb.valiantui.interaction.pressScale
import io.github.eduardomcb.valiantui.theme.ValiantColorRole
import io.github.eduardomcb.valiantui.theme.ValiantRadius
import io.github.eduardomcb.valiantui.theme.ValiantTheme

enum class ButtonVariant {
    Solid,
    Flat,
    Bordered,
    Light,
    Ghost,
    Shadow
}

enum class ButtonSize(
    val height: Dp,
    val minWidth: Dp,
    val horizontalPadding: Dp,
    val gap: Dp,
    val defaultRadius: ValiantRadius,
    val spinnerSize: SpinnerSize
) {
    Sm(
        height = 32.dp,
        minWidth = 64.dp,
        horizontalPadding = 12.dp,
        gap = 8.dp,
        defaultRadius = ValiantRadius.Sm,
        spinnerSize = SpinnerSize.Sm
    ),
    Md(
        height = 40.dp,
        minWidth = 80.dp,
        horizontalPadding = 16.dp,
        gap = 8.dp,
        defaultRadius = ValiantRadius.Md,
        spinnerSize = SpinnerSize.Md
    ),
    Lg(
        height = 48.dp,
        minWidth = 96.dp,
        horizontalPadding = 24.dp,
        gap = 12.dp,
        defaultRadius = ValiantRadius.Lg,
        spinnerSize = SpinnerSize.Lg
    )
}

@Immutable
data class ButtonStyle(
    val backgroundColor: Color,
    val contentColor: Color,
    val borderStroke: BorderStroke? = null,
    val shadowElevation: Dp = 0.dp,
    val shadowColor: Color = Color.Transparent
)

@Composable
fun rememberButtonStyle(
    variant: ButtonVariant,
    colorRole: ValiantColorRole,
    isHovered: Boolean,
    isPressed: Boolean
): ButtonStyle {
    val themeColors = ValiantTheme.colors
    val colorPair = themeColors.forRole(colorRole)
    val baseColor = colorPair.color
    val onBaseColor = colorPair.onColor

    return when (variant) {
        ButtonVariant.Solid -> {
            ButtonStyle(
                backgroundColor = baseColor,
                contentColor = onBaseColor
            )
        }
        ButtonVariant.Flat -> {
            val flatAlpha = if (colorRole == ValiantColorRole.Default) 0.40f else 0.20f
            val contentColor = if (colorRole == ValiantColorRole.Default) themeColors.foreground else baseColor
            ButtonStyle(
                backgroundColor = baseColor.copy(alpha = flatAlpha),
                contentColor = contentColor
            )
        }
        ButtonVariant.Bordered -> {
            val contentColor = if (colorRole == ValiantColorRole.Default) themeColors.foreground else baseColor
            ButtonStyle(
                backgroundColor = Color.Transparent,
                contentColor = contentColor,
                borderStroke = BorderStroke(2.dp, baseColor)
            )
        }
        ButtonVariant.Light -> {
            val contentColor = if (colorRole == ValiantColorRole.Default) themeColors.foreground else baseColor
            val bg = if (isHovered || isPressed) baseColor.copy(alpha = 0.15f) else Color.Transparent
            ButtonStyle(
                backgroundColor = bg,
                contentColor = contentColor
            )
        }
        ButtonVariant.Ghost -> {
            val isActive = isHovered || isPressed
            val bg = if (isActive) baseColor else Color.Transparent
            val contentColor = if (isActive) onBaseColor else baseColor
            ButtonStyle(
                backgroundColor = bg,
                contentColor = contentColor,
                borderStroke = BorderStroke(2.dp, baseColor)
            )
        }
        ButtonVariant.Shadow -> {
            ButtonStyle(
                backgroundColor = baseColor,
                contentColor = onBaseColor,
                shadowElevation = 8.dp,
                shadowColor = baseColor.copy(alpha = 0.40f)
            )
        }
    }
}

@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: ButtonVariant = ButtonVariant.Solid,
    color: ValiantColorRole = ValiantColorRole.Primary,
    size: ButtonSize = ButtonSize.Md,
    radius: ValiantRadius = size.defaultRadius,
    isLoading: Boolean = false,
    isDisabled: Boolean = false,
    isIconOnly: Boolean = false,
    fullWidth: Boolean = false,
    customShape: Shape? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    startContent: (@Composable () -> Unit)? = null,
    endContent: (@Composable () -> Unit)? = null,
    content: @Composable RowScope.() -> Unit
) {
    val isHovered by interactionSource.collectIsHoveredAsState()
    val isPressed by interactionSource.collectIsPressedAsState()

    val shape = customShape ?: radius.toShape()
    val buttonStyle = rememberButtonStyle(
        variant = variant,
        colorRole = color,
        isHovered = isHovered,
        isPressed = isPressed
    )

    val animatedBgColor by animateColorAsState(
        targetValue = buttonStyle.backgroundColor,
        animationSpec = tween(durationMillis = 150),
        label = "buttonBgColor"
    )
    val animatedContentColor by animateColorAsState(
        targetValue = buttonStyle.contentColor,
        animationSpec = tween(durationMillis = 150),
        label = "buttonContentColor"
    )

    val textStyle = when (size) {
        ButtonSize.Sm -> ValiantTheme.typography.tiny
        ButtonSize.Md -> ValiantTheme.typography.small
        ButtonSize.Lg -> ValiantTheme.typography.medium
    }

    val isClickable = !isDisabled && !isLoading

    val baseModifier = modifier
        .semantics { role = Role.Button }
        .pressScale(interactionSource = interactionSource, enabled = isClickable)
        .pointerCursor(enabled = isClickable)
        .then(if (fullWidth) Modifier.fillMaxWidth() else Modifier)
        .then(
            if (isIconOnly) {
                Modifier.size(size.height)
            } else {
                Modifier
                    .height(size.height)
                    .defaultMinSize(minWidth = size.minWidth)
            }
        )
        .then(
            if (buttonStyle.shadowElevation > 0.dp) {
                Modifier.shadow(
                    elevation = buttonStyle.shadowElevation,
                    shape = shape,
                    spotColor = buttonStyle.shadowColor,
                    ambientColor = buttonStyle.shadowColor
                )
            } else {
                Modifier
            }
        )
        .clip(shape)
        .then(
            if (buttonStyle.borderStroke != null) {
                Modifier.border(buttonStyle.borderStroke, shape)
            } else {
                Modifier
            }
        )
        .drawBehind {
            drawRect(animatedBgColor)
        }
        .clickable(
            interactionSource = interactionSource,
            indication = null,
            enabled = isClickable,
            onClick = onClick
        )
        .alpha(if (isDisabled) 0.5f else 1f)

    val horizontalPadding = if (isIconOnly) 0.dp else size.horizontalPadding

    Box(
        modifier = baseModifier.padding(PaddingValues(horizontal = horizontalPadding)),
        contentAlignment = Alignment.Center
    ) {
        CompositionLocalProvider(
            LocalContentColor provides animatedContentColor,
            LocalTextStyle provides textStyle
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    space = if (isIconOnly) 0.dp else size.gap,
                    alignment = Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (isLoading) {
                    Spinner(
                        size = size.spinnerSize,
                        color = animatedContentColor
                    )
                } else if (startContent != null) {
                    startContent()
                }

                content()

                if (!isLoading && endContent != null) {
                    endContent()
                }
            }
        }
    }
}
