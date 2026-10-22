package io.github.eduardomcb.valiantui.components.separator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.eduardomcb.valiantui.theme.ValiantTheme

/**
 * Axis along which the separator rule is rendered.
 */
enum class SeparatorOrientation {
    Horizontal,
    Vertical
}

/**
 * Visual contrast weight of the separator, matching HeroUI's hierarchy.
 *
 * - [Default]: Subtle contrast, ideal for high-content-density layouts.
 * - [Secondary]: Medium contrast, suitable for neutral surfaces and grouping related content.
 * - [Tertiary]: Strongest contrast, used when distinct separation is required.
 */
enum class SeparatorVariant {
    Default,
    Secondary,
    Tertiary
}

@Immutable
object SeparatorDefaults {
    val Thickness: Dp = 1.dp
    val LabelPadding: Dp = 12.dp

    @Composable
    @ReadOnlyComposable
    fun colorFor(variant: SeparatorVariant): Color {
        val colors = ValiantTheme.colors
        return when (variant) {
            SeparatorVariant.Default -> if (colors.isDark) Color(0x1FFFFFFF) else Color(0x1F11181C)
            SeparatorVariant.Secondary -> colors.divider
            SeparatorVariant.Tertiary -> if (colors.isDark) Color(0x40FFFFFF) else Color(0x4011181C)
        }
    }
}

/**
 * ValiantUI Separator component.
 *
 * Visually divides content sections horizontally or vertically, with support for
 * three contrast variants and an optional centered label (e.g. "OR").
 *
 * @param modifier Modifier to be applied to the separator container.
 * @param orientation Direction of the separator ([SeparatorOrientation.Horizontal] or [SeparatorOrientation.Vertical]).
 * @param variant Visual weight ([SeparatorVariant.Default], [SeparatorVariant.Secondary], or [SeparatorVariant.Tertiary]).
 * @param color Explicit color override. If null, the color resolves from [variant] and [ValiantTheme.colors].
 * @param thickness Width for vertical separators or height for horizontal separators. Defaults to 1.dp.
 * @param text Optional text rendered at the center of the rule.
 * @param label Optional custom composable slot rendered at the center of the rule. Takes precedence over [text].
 */
@Composable
fun Separator(
    modifier: Modifier = Modifier,
    orientation: SeparatorOrientation = SeparatorOrientation.Horizontal,
    variant: SeparatorVariant = SeparatorVariant.Default,
    color: Color? = null,
    thickness: Dp = SeparatorDefaults.Thickness,
    text: String? = null,
    label: (@Composable () -> Unit)? = null
) {
    val effectiveColor = color ?: SeparatorDefaults.colorFor(variant)
    val hasContent = label != null || !text.isNullOrEmpty()

    if (!hasContent) {
        val lineModifier = when (orientation) {
            SeparatorOrientation.Horizontal -> modifier.fillMaxWidth().height(thickness)
            SeparatorOrientation.Vertical -> modifier.fillMaxHeight().width(thickness)
        }
        Box(modifier = lineModifier.background(effectiveColor))
        return
    }

    val labelColor = ValiantTheme.colors.foreground.copy(alpha = 0.6f)
    val labelContent: @Composable () -> Unit = {
        CompositionLocalProvider(
            LocalContentColor provides labelColor,
            LocalTextStyle provides ValiantTheme.typography.tiny
        ) {
            if (label != null) {
                label()
            } else if (text != null) {
                Text(text = text)
            }
        }
    }

    when (orientation) {
        SeparatorOrientation.Horizontal -> {
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(thickness)
                        .background(effectiveColor)
                )
                Box(modifier = Modifier.padding(horizontal = SeparatorDefaults.LabelPadding)) {
                    labelContent()
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(thickness)
                        .background(effectiveColor)
                )
            }
        }
        SeparatorOrientation.Vertical -> {
            Column(
                modifier = modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .width(thickness)
                        .background(effectiveColor)
                )
                Box(modifier = Modifier.padding(vertical = SeparatorDefaults.LabelPadding)) {
                    labelContent()
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .width(thickness)
                        .background(effectiveColor)
                )
            }
        }
    }
}
