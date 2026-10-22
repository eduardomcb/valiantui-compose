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
 * Grounded directly on the official HeroUI v3 `variables.css` OKLCH color definitions:
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
    val divider: Color get() = separator
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

/**
 * Creates a light [ValiantColors] instance conforming to HeroUI v3 specifications.
 */
fun lightValiantColors(
    // Base Canvas: oklch(0.9702 0 0) and --eclipse oklch(0.2103 0.0059 285.89)
    background: Color = Color(0xFFF5F5F5),
    backgroundSecondary: Color = Color(0xFFEBEBEC),
    backgroundTertiary: Color = Color(0xFFE2E2E3),
    foreground: Color = Color(0xFF18181B),
    muted: Color = Color(0xFF71717A),

    // Surfaces & Overlays: --white and subtle tint layers
    surface: Color = Color(0xFFFFFFFF),
    surfaceSecondary: Color = Color(0xFFEFEFF0),
    surfaceTertiary: Color = Color(0xFFEAEAEB),
    overlay: Color = Color(0xFFFFFFFF),
    segment: Color = Color(0xFFFFFFFF),

    // Form Fields
    fieldBackground: Color = Color(0xFFFFFFFF),
    fieldForeground: Color = Color(0xFF18181B),
    fieldPlaceholder: Color = Color(0xFF71717A),
    fieldBorder: Color = Color(0x2618181B),

    // Action Roles
    default: ValiantColorPair = ValiantColorPair(
        color = Color(0xFFEBEBEC),
        onColor = Color(0xFF18181B)
    ),
    accent: ValiantColorPair = ValiantColorPair(
        color = Color(0xFF0485F7), // HeroUI v3 oklch(0.6204 0.195 253.83)
        onColor = Color(0xFFFCFCFC)  // HeroUI v3 --snow oklch(0.9911 0 0)
    ),
    secondary: ValiantColorPair = ValiantColorPair(
        color = Color(0xFF7828C8),
        onColor = Color(0xFFFFFFFF)
    ),
    success: ValiantColorPair = ValiantColorPair(
        color = Color(0xFF17C964), // oklch(0.7329 0.1935 150.81)
        onColor = Color(0xFF18181B)
    ),
    warning: ValiantColorPair = ValiantColorPair(
        color = Color(0xFFF5A524), // oklch(0.7819 0.1585 72.33)
        onColor = Color(0xFF18181B)
    ),
    danger: ValiantColorPair = ValiantColorPair(
        color = Color(0xFFFF383C), // HeroUI v3 scarlet oklch(0.6532 0.2328 25.74)
        onColor = Color(0xFFFCFCFC)
    ),

    // Boundaries & Dividers
    separator: Color = Color(0xFFE4E4E7),          // oklch(92% 0.004 286.32)
    separatorSecondary: Color = Color(0xFFDCDCE0), // color-mix(surface 85%, surface-foreground 15%)
    separatorTertiary: Color = Color(0xFFD4D4D8),  // color-mix(surface 81%, surface-foreground 19%)
    border: Color = Color(0xFFDEDEE0),             // oklch(90% 0.004 286.32)

    // Utilities
    focus: Color = Color(0xFF0485F7),
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

/**
 * Creates a dark [ValiantColors] instance conforming to HeroUI v3 specifications.
 */
fun darkValiantColors(
    // Base Canvas: oklch(12% 0.005 285.823) and --snow oklch(0.9911 0 0)
    background: Color = Color(0xFF060607),
    backgroundSecondary: Color = Color(0xFF101012),
    backgroundTertiary: Color = Color(0xFF1A1A1D),
    foreground: Color = Color(0xFFFCFCFC),
    muted: Color = Color(0xFF9F9FA9),

    // Surfaces & Overlays: oklch(0.2103 0.0059 285.89)
    surface: Color = Color(0xFF18181B),
    surfaceSecondary: Color = Color(0xFF232325),
    surfaceTertiary: Color = Color(0xFF262728),
    overlay: Color = Color(0xFF18181B),
    segment: Color = Color(0xFF3F3F46),

    // Form Fields
    fieldBackground: Color = Color(0xFF18181B),
    fieldForeground: Color = Color(0xFFFCFCFC),
    fieldPlaceholder: Color = Color(0xFF9F9FA9),
    fieldBorder: Color = Color(0x26FFFFFF),

    // Action Roles
    default: ValiantColorPair = ValiantColorPair(
        color = Color(0xFF27272A),
        onColor = Color(0xFFFCFCFC)
    ),
    accent: ValiantColorPair = ValiantColorPair(
        color = Color(0xFF0485F7), // oklch(0.6204 0.195 253.83)
        onColor = Color(0xFFFCFCFC)
    ),
    secondary: ValiantColorPair = ValiantColorPair(
        color = Color(0xFF9353D3),
        onColor = Color(0xFFFFFFFF)
    ),
    success: ValiantColorPair = ValiantColorPair(
        color = Color(0xFF17C964),
        onColor = Color(0xFF18181B)
    ),
    warning: ValiantColorPair = ValiantColorPair(
        color = Color(0xFFF7B750), // oklch(0.8203 0.1388 76.34)
        onColor = Color(0xFF18181B)
    ),
    danger: ValiantColorPair = ValiantColorPair(
        color = Color(0xFFDB3B3E), // oklch(0.594 0.1967 24.63)
        onColor = Color(0xFFFCFCFC)
    ),

    // Boundaries & Dividers
    separator: Color = Color(0xFF212124),          // oklch(25% 0.006 286.033)
    separatorSecondary: Color = Color(0xFF333336), // color-mix(surface 85%, surface-foreground 15%)
    separatorTertiary: Color = Color(0xFF404044),  // color-mix(surface 81%, surface-foreground 19%)
    border: Color = Color(0xFF28282C),             // oklch(28% 0.006 286.033)

    // Utilities
    focus: Color = Color(0xFF0485F7),
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
