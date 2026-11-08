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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.eduardomcb.valiantui.components.feedback.Spinner
import io.github.eduardomcb.valiantui.components.feedback.SpinnerSize
import io.github.eduardomcb.valiantui.interaction.pointerCursor
import io.github.eduardomcb.valiantui.interaction.pressScale
import io.github.eduardomcb.valiantui.theme.ValiantColorRole
import io.github.eduardomcb.valiantui.theme.ValiantRadius
import io.github.eduardomcb.valiantui.theme.ValiantTheme

/**
 * Visual styling variants matching HeroUI v3 semantic hierarchy.
 */
enum class ButtonVariant {
    Primary,
    Secondary,
    Tertiary,
    Outline,
    Ghost,
    Danger,
    DangerSoft
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
        defaultRadius = ValiantRadius.Full,
        spinnerSize = SpinnerSize.Sm
    ),
    Md(
        height = 40.dp,
        minWidth = 80.dp,
        horizontalPadding = 16.dp,
        gap = 8.dp,
        defaultRadius = ValiantRadius.Full,
        spinnerSize = SpinnerSize.Md
    ),
    Lg(
        height = 48.dp,
        minWidth = 96.dp,
        horizontalPadding = 24.dp,
        gap = 12.dp,
        defaultRadius = ValiantRadius.Full,
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
    colorRole: ValiantColorRole? = null,
    isHovered: Boolean = false,
    isPressed: Boolean = false
): ButtonStyle {
    val themeColors = ValiantTheme.colors
    val resolvedRole = colorRole ?: when (variant) {
        ButtonVariant.Primary -> ValiantColorRole.Primary
        ButtonVariant.Secondary -> ValiantColorRole.Secondary
        ButtonVariant.Tertiary -> ValiantColorRole.Default
        ButtonVariant.Outline -> ValiantColorRole.Default
        ButtonVariant.Ghost -> ValiantColorRole.Default
        ButtonVariant.Danger, ButtonVariant.DangerSoft -> ValiantColorRole.Danger
    }
    val colorPair = themeColors.forRole(resolvedRole)
    val baseColor = colorPair.color
    val onBaseColor = colorPair.onColor

    return when (variant) {
        ButtonVariant.Primary -> {
            ButtonStyle(
                backgroundColor = baseColor,
                contentColor = onBaseColor
            )
        }
        ButtonVariant.Secondary -> {
            if (colorRole != null) {
                ButtonStyle(
                    backgroundColor = themeColors.default.color,
                    contentColor = baseColor
                )
            } else {
                val textBlue = if (themeColors.isDark) Color(0xFF60A8FA) else themeColors.accent.color
                ButtonStyle(
                    backgroundColor = themeColors.default.color,
                    contentColor = textBlue
                )
            }
        }
        ButtonVariant.Tertiary -> {
            ButtonStyle(
                backgroundColor = themeColors.default.color,
                contentColor = themeColors.foreground
            )
        }
        ButtonVariant.Outline -> {
            val borderColor = if (colorRole != null) baseColor else if (themeColors.isDark) Color(0xFF27272A) else themeColors.border
            val contentColor = if (colorRole != null) baseColor else themeColors.foreground
            val bg = if (isHovered || isPressed) {
                if (colorRole != null) baseColor.copy(alpha = 0.10f) else themeColors.default.color.copy(alpha = 0.50f)
            } else Color.Transparent
            ButtonStyle(
                backgroundColor = bg,
                contentColor = contentColor,
                borderStroke = BorderStroke(1.dp, borderColor)
            )
        }
        ButtonVariant.Ghost -> {
            val contentColor = if (colorRole != null) baseColor else themeColors.foreground
            val bg = if (isHovered || isPressed) {
                if (colorRole != null) baseColor.copy(alpha = 0.15f) else themeColors.default.color.copy(alpha = 0.50f)
            } else Color.Transparent
            ButtonStyle(
                backgroundColor = bg,
                contentColor = contentColor
            )
        }
        ButtonVariant.Danger -> {
            ButtonStyle(
                backgroundColor = themeColors.danger.color,
                contentColor = themeColors.danger.onColor
            )
        }
        ButtonVariant.DangerSoft -> {
            val bg = if (themeColors.isDark) Color(0xFF260E0F) else Color(0xFFFEECEE)
            val fg = if (themeColors.isDark) Color(0xFFEB7872) else themeColors.danger.color
            ButtonStyle(
                backgroundColor = bg,
                contentColor = fg
            )
        }
    }
}

@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: ButtonVariant = ButtonVariant.Primary,
    color: ValiantColorRole? = null,
    size: ButtonSize = ButtonSize.Md,
    radius: ValiantRadius = ValiantRadius.Full,
    isLoading: Boolean = false,
    isPending: Boolean = isLoading,
    showDefaultSpinner: Boolean = true,
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
        ButtonSize.Sm -> ValiantTheme.typography.tiny.copy(fontWeight = FontWeight.Medium)
        ButtonSize.Md -> ValiantTheme.typography.small.copy(fontWeight = FontWeight.Medium)
        ButtonSize.Lg -> ValiantTheme.typography.medium.copy(fontWeight = FontWeight.Medium)
    }

    val pending = isLoading || isPending
    val isClickable = !isDisabled && !pending

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
        .alpha(if (isDisabled || pending) 0.5f else 1f)

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
                if (pending && showDefaultSpinner) {
                    Spinner(
                        size = size.spinnerSize,
                        color = animatedContentColor
                    )
                } else if (startContent != null) {
                    startContent()
                }

                content()

                if (!pending && endContent != null) {
                    endContent()
                }
            }
        }
    }
}
