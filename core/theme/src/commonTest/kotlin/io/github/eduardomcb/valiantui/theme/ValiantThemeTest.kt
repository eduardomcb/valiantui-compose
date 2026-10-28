package io.github.eduardomcb.valiantui.theme

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValiantThemeTest {

    private val density = Density(density = 1f)
    private val layoutSize = androidx.compose.ui.geometry.Size(100f, 100f)

    @Test
    fun colorRole_mappingReturnsCorrespondingColorPair() {
        val light = lightValiantColors()

        assertEquals(light.default, light.forRole(ValiantColorRole.Default))
        assertEquals(light.accent, light.forRole(ValiantColorRole.Accent))
        assertEquals(light.accent, light.forRole(ValiantColorRole.Primary))
        assertEquals(light.secondary, light.forRole(ValiantColorRole.Secondary))
        assertEquals(light.success, light.forRole(ValiantColorRole.Success))
        assertEquals(light.warning, light.forRole(ValiantColorRole.Warning))
        assertEquals(light.danger, light.forRole(ValiantColorRole.Danger))
    }

    @Test
    fun compatibilityAliases_pointToExpectedHeroUiTokens() {
        val light = lightValiantColors()

        assertEquals(light.accent, light.primary)
        assertEquals(light.separator, light.divider)
        assertEquals(light.surface, light.content1)
        assertEquals(light.surfaceSecondary, light.content2)
        assertEquals(light.surfaceTertiary, light.content3)
    }

    @Test
    fun darkModeFlag_correctlyReflectsColorPalette() {
        assertTrue(darkValiantColors().isDark, "darkValiantColors must have isDark = true")
        assertFalse(lightValiantColors().isDark, "lightValiantColors must have isDark = false")
    }

    @Test
    fun radiusToShape_createsExpectedCornerRadii() {
        val smShape = ValiantRadius.Sm.toShape(
            topStart = true,
            topEnd = false,
            bottomEnd = false,
            bottomStart = true
        )

        val topStartPx = smShape.topStart.toPx(layoutSize, density)
        val topEndPx = smShape.topEnd.toPx(layoutSize, density)
        val bottomEndPx = smShape.bottomEnd.toPx(layoutSize, density)
        val bottomStartPx = smShape.bottomStart.toPx(layoutSize, density)

        assertEquals(8f, topStartPx, "topStart should have 8dp radius")
        assertEquals(0f, topEndPx, "topEnd should be 0dp when disabled")
        assertEquals(0f, bottomEndPx, "bottomEnd should be 0dp when disabled")
        assertEquals(8f, bottomStartPx, "bottomStart should have 8dp radius")
    }

    @Test
    fun radiusFull_producesCircleCorners() {
        val fullShape = ValiantRadius.Full.toShape()
        val cornerPx = fullShape.topStart.toPx(layoutSize, density)

        // 50% of 100f is 50f
        assertEquals(50f, cornerPx, "Full radius should create 50% circle corner")
    }
}
