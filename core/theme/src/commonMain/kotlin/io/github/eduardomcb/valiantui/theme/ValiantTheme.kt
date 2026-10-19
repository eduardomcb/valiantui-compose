package io.github.eduardomcb.valiantui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

val LocalValiantColors = staticCompositionLocalOf { lightValiantColors() }
val LocalValiantTypography = staticCompositionLocalOf { ValiantTypography() }
val LocalValiantRadius = staticCompositionLocalOf { ValiantRadius.Md }
val LocalValiantShapes = staticCompositionLocalOf { ValiantShapes() }
val LocalValiantSpacing = staticCompositionLocalOf { ValiantSpacing() }

@Composable
fun ValiantTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: ValiantColors = if (darkTheme) darkValiantColors() else lightValiantColors(),
    typography: ValiantTypography = ValiantTypography(),
    defaultRadius: ValiantRadius = ValiantRadius.Md,
    shapes: ValiantShapes = ValiantShapes(),
    spacing: ValiantSpacing = ValiantSpacing(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalValiantColors provides colors,
        LocalValiantTypography provides typography,
        LocalValiantRadius provides defaultRadius,
        LocalValiantShapes provides shapes,
        LocalValiantSpacing provides spacing,
        content = content
    )
}

object ValiantTheme {
    val colors: ValiantColors
        @Composable
        @ReadOnlyComposable
        get() = LocalValiantColors.current

    val typography: ValiantTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalValiantTypography.current

    val defaultRadius: ValiantRadius
        @Composable
        @ReadOnlyComposable
        get() = LocalValiantRadius.current

    val shapes: ValiantShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalValiantShapes.current

    val spacing: ValiantSpacing
        @Composable
        @ReadOnlyComposable
        get() = LocalValiantSpacing.current
}
