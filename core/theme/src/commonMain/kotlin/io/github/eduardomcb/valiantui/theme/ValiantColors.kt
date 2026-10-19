package io.github.eduardomcb.valiantui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

enum class ValiantColorRole {
    Default,
    Primary,
    Secondary,
    Success,
    Warning,
    Danger
}

@Immutable
data class ValiantColorPair(
    val color: Color,
    val onColor: Color
)

@Immutable
data class ValiantColors(
    val isDark: Boolean,
    val background: Color,
    val foreground: Color,
    val content1: Color,
    val content2: Color,
    val content3: Color,
    val content4: Color,
    val divider: Color,
    val default: ValiantColorPair,
    val primary: ValiantColorPair,
    val secondary: ValiantColorPair,
    val success: ValiantColorPair,
    val warning: ValiantColorPair,
    val danger: ValiantColorPair,
    val focus: Color
) {
    fun forRole(role: ValiantColorRole): ValiantColorPair = when (role) {
        ValiantColorRole.Default -> default
        ValiantColorRole.Primary -> primary
        ValiantColorRole.Secondary -> secondary
        ValiantColorRole.Success -> success
        ValiantColorRole.Warning -> warning
        ValiantColorRole.Danger -> danger
    }
}

fun lightValiantColors(
    background: Color = Color(0xFFFFFFFF),
    foreground: Color = Color(0xFF11181C),
    content1: Color = Color(0xFFFFFFFF),
    content2: Color = Color(0xFFF4F4F5),
    content3: Color = Color(0xFFE4E4E7),
    content4: Color = Color(0xFFD4D4D8),
    divider: Color = Color(0x2611181C),
    default: ValiantColorPair = ValiantColorPair(
        color = Color(0xFFE4E4E7),
        onColor = Color(0xFF11181C)
    ),
    primary: ValiantColorPair = ValiantColorPair(
        color = Color(0xFF006FEE),
        onColor = Color(0xFFFFFFFF)
    ),
    secondary: ValiantColorPair = ValiantColorPair(
        color = Color(0xFF7828C8),
        onColor = Color(0xFFFFFFFF)
    ),
    success: ValiantColorPair = ValiantColorPair(
        color = Color(0xFF17C964),
        onColor = Color(0xFF000000)
    ),
    warning: ValiantColorPair = ValiantColorPair(
        color = Color(0xFFF5A524),
        onColor = Color(0xFF000000)
    ),
    danger: ValiantColorPair = ValiantColorPair(
        color = Color(0xFFF31260),
        onColor = Color(0xFFFFFFFF)
    ),
    focus: Color = Color(0xFF006FEE)
): ValiantColors = ValiantColors(
    isDark = false,
    background = background,
    foreground = foreground,
    content1 = content1,
    content2 = content2,
    content3 = content3,
    content4 = content4,
    divider = divider,
    default = default,
    primary = primary,
    secondary = secondary,
    success = success,
    warning = warning,
    danger = danger,
    focus = focus
)

fun darkValiantColors(
    background: Color = Color(0xFF000000),
    foreground: Color = Color(0xFFECEDEE),
    content1: Color = Color(0xFF18181B),
    content2: Color = Color(0xFF27272A),
    content3: Color = Color(0xFF3F3F46),
    content4: Color = Color(0xFF52525B),
    divider: Color = Color(0x26FFFFFF),
    default: ValiantColorPair = ValiantColorPair(
        color = Color(0xFF27272A),
        onColor = Color(0xFFECEDEE)
    ),
    primary: ValiantColorPair = ValiantColorPair(
        color = Color(0xFF006FEE),
        onColor = Color(0xFFFFFFFF)
    ),
    secondary: ValiantColorPair = ValiantColorPair(
        color = Color(0xFF9353D3),
        onColor = Color(0xFFFFFFFF)
    ),
    success: ValiantColorPair = ValiantColorPair(
        color = Color(0xFF17C964),
        onColor = Color(0xFF000000)
    ),
    warning: ValiantColorPair = ValiantColorPair(
        color = Color(0xFFF5A524),
        onColor = Color(0xFF000000)
    ),
    danger: ValiantColorPair = ValiantColorPair(
        color = Color(0xFFF31260),
        onColor = Color(0xFFFFFFFF)
    ),
    focus: Color = Color(0xFF006FEE)
): ValiantColors = ValiantColors(
    isDark = true,
    background = background,
    foreground = foreground,
    content1 = content1,
    content2 = content2,
    content3 = content3,
    content4 = content4,
    divider = divider,
    default = default,
    primary = primary,
    secondary = secondary,
    success = success,
    warning = warning,
    danger = danger,
    focus = focus
)
