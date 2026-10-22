package io.github.eduardomcb.valiantui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Semantic action and status roles matching HeroUI v3.
 */
enum class ValiantColorRole {
    Default,
    Accent,
    Primary,    // Alias to Accent for Compose ergonomics
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

/**
 * HeroUI v3 semantic color system implementation for Compose Multiplatform.
 *
 * Organized by architectural role rather than visual abundance:
 * - Canvas & Base: [background], [backgroundSecondary], [backgroundTertiary], [foreground], [muted]
 * - Surfaces & Overlays: [surface], [surfaceSecondary], [surfaceTertiary], [overlay], [segment]
 * - Form Fields: [fieldBackground], [fieldForeground], [fieldPlaceholder], [fieldBorder]
 * - Action Roles: [default], [accent], [secondary], [success], [warning], [danger]
 * - Boundaries: [separator], [separatorSecondary], [separatorTertiary], [border]
 * - Utilities: [focus], [backdrop]
 */
@Immutable
data class ValiantColors(
    val isDark: Boolean,

    // Base Canvas
    val background: Color,
    val backgroundSecondary: Color,
    val backgroundTertiary: Color,
    val foreground: Color,
    val muted: Color,

    // Surfaces & Overlays (Cards, Modals, Menus, Panels)
    val surface: Color,
    val surfaceSecondary: Color,
    val surfaceTertiary: Color,
    val overlay: Color,
    val segment: Color,

    // Form Fields (Inputs, TextAreas, Selects)
    val fieldBackground: Color,
    val fieldForeground: Color,
    val fieldPlaceholder: Color,
    val fieldBorder: Color,

    // Action Roles
    val default: ValiantColorPair,
    val accent: ValiantColorPair,
    val secondary: ValiantColorPair,
    val success: ValiantColorPair,
    val warning: ValiantColorPair,
    val danger: ValiantColorPair,

    // Boundaries & Dividers
    val separator: Color,
    val separatorSecondary: Color,
    val separatorTertiary: Color,
    val border: Color,

    // Feedback & Utility
    val focus: Color,
    val backdrop: Color
) {
    // Backwards-compatibility and Compose-ergonomic aliases
    val primary: ValiantColorPair get() = accent
    val divider: Color get() = separatorSecondary
    val content1: Color get() = surface
    val content2: Color get() = surfaceSecondary
    val content3: Color get() = surfaceTertiary
    val content4: Color get() = surfaceTertiary

    fun forRole(role: ValiantColorRole): ValiantColorPair = when (role) {
        ValiantColorRole.Default -> default
        ValiantColorRole.Accent, ValiantColorRole.Primary -> accent
        ValiantColorRole.Secondary -> secondary
        ValiantColorRole.Success -> success
        ValiantColorRole.Warning -> warning
        ValiantColorRole.Danger -> danger
    }
}

fun lightValiantColors(
    background: Color = Color(0xFFFAFAFA),
    backgroundSecondary: Color = Color(0xFFF4F4F5),
    backgroundTertiary: Color = Color(0xFFE4E4E7),
    foreground: Color = Color(0xFF11181C),
    muted: Color = Color(0xFF71717A),

    surface: Color = Color(0xFFFFFFFF),
    surfaceSecondary: Color = Color(0xFFF4F4F5),
    surfaceTertiary: Color = Color(0xFFE4E4E7),
    overlay: Color = Color(0xFFFFFFFF),
    segment: Color = Color(0xFFFFFFFF),

    fieldBackground: Color = Color(0xFFFFFFFF),
    fieldForeground: Color = Color(0xFF11181C),
    fieldPlaceholder: Color = Color(0xFF71717A),
    fieldBorder: Color = Color(0x2611181C),

    default: ValiantColorPair = ValiantColorPair(
        color = Color(0xFFE4E4E7),
        onColor = Color(0xFF11181C)
    ),
    accent: ValiantColorPair = ValiantColorPair(
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

    separator: Color = Color(0x1F11181C),
    separatorSecondary: Color = Color(0x2611181C),
    separatorTertiary: Color = Color(0x4011181C),
    border: Color = Color(0x2611181C),

    focus: Color = Color(0xFF006FEE),
    backdrop: Color = Color(0x80000000)
): ValiantColors = ValiantColors(
    isDark = false,
    background = background,
    backgroundSecondary = backgroundSecondary,
    backgroundTertiary = backgroundTertiary,
    foreground = foreground,
    muted = muted,
    surface = surface,
    surfaceSecondary = surfaceSecondary,
    surfaceTertiary = surfaceTertiary,
    overlay = overlay,
    segment = segment,
    fieldBackground = fieldBackground,
    fieldForeground = fieldForeground,
    fieldPlaceholder = fieldPlaceholder,
    fieldBorder = fieldBorder,
    default = default,
    accent = accent,
    secondary = secondary,
    success = success,
    warning = warning,
    danger = danger,
    separator = separator,
    separatorSecondary = separatorSecondary,
    separatorTertiary = separatorTertiary,
    border = border,
    focus = focus,
    backdrop = backdrop
)

fun darkValiantColors(
    background: Color = Color(0xFF000000),
    backgroundSecondary: Color = Color(0xFF18181B),
    backgroundTertiary: Color = Color(0xFF27272A),
    foreground: Color = Color(0xFFECEDEE),
    muted: Color = Color(0xFFA1A1AA),

    surface: Color = Color(0xFF18181B),
    surfaceSecondary: Color = Color(0xFF27272A),
    surfaceTertiary: Color = Color(0xFF3F3F46),
    overlay: Color = Color(0xFF1F1F23),
    segment: Color = Color(0xFF3F3F46),

    fieldBackground: Color = Color(0xFF27272A),
    fieldForeground: Color = Color(0xFFECEDEE),
    fieldPlaceholder: Color = Color(0xFFA1A1AA),
    fieldBorder: Color = Color(0x26FFFFFF),

    default: ValiantColorPair = ValiantColorPair(
        color = Color(0xFF27272A),
        onColor = Color(0xFFECEDEE)
    ),
    accent: ValiantColorPair = ValiantColorPair(
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

    separator: Color = Color(0x1FFFFFFF),
    separatorSecondary: Color = Color(0x26FFFFFF),
    separatorTertiary: Color = Color(0x40FFFFFF),
    border: Color = Color(0x26FFFFFF),

    focus: Color = Color(0xFF006FEE),
    backdrop: Color = Color(0x99000000)
): ValiantColors = ValiantColors(
    isDark = true,
    background = background,
    backgroundSecondary = backgroundSecondary,
    backgroundTertiary = backgroundTertiary,
    foreground = foreground,
    muted = muted,
    surface = surface,
    surfaceSecondary = surfaceSecondary,
    surfaceTertiary = surfaceTertiary,
    overlay = overlay,
    segment = segment,
    fieldBackground = fieldBackground,
    fieldForeground = fieldForeground,
    fieldPlaceholder = fieldPlaceholder,
    fieldBorder = fieldBorder,
    default = default,
    accent = accent,
    secondary = secondary,
    success = success,
    warning = warning,
    danger = danger,
    separator = separator,
    separatorSecondary = separatorSecondary,
    separatorTertiary = separatorTertiary,
    border = border,
    focus = focus,
    backdrop = backdrop
)
