package io.github.eduardomcb.valiantui.components.button

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.github.eduardomcb.valiantui.theme.ValiantColorRole
import io.github.eduardomcb.valiantui.theme.ValiantRadius
import io.github.eduardomcb.valiantui.theme.darkValiantColors
import io.github.eduardomcb.valiantui.theme.lightValiantColors
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ButtonTest {

    @Test
    fun testRadiusTokenValues() {
        assertEquals(0.dp, ValiantRadius.None.dp)
        assertEquals(8.dp, ValiantRadius.Sm.dp)
        assertEquals(12.dp, ValiantRadius.Md.dp)
        assertEquals(14.dp, ValiantRadius.Lg.dp)
        assertEquals(9999.dp, ValiantRadius.Full.dp)
    }

    @Test
    fun testButtonSizes() {
        assertEquals(32.dp, ButtonSize.Sm.height)
        assertEquals(64.dp, ButtonSize.Sm.minWidth)
        assertEquals(12.dp, ButtonSize.Sm.horizontalPadding)
        assertEquals(8.dp, ButtonSize.Sm.gap)

        assertEquals(40.dp, ButtonSize.Md.height)
        assertEquals(80.dp, ButtonSize.Md.minWidth)
        assertEquals(16.dp, ButtonSize.Md.horizontalPadding)
        assertEquals(8.dp, ButtonSize.Md.gap)

        assertEquals(48.dp, ButtonSize.Lg.height)
        assertEquals(96.dp, ButtonSize.Lg.minWidth)
        assertEquals(24.dp, ButtonSize.Lg.horizontalPadding)
        assertEquals(12.dp, ButtonSize.Lg.gap)
    }

    @Test
    fun testSemanticColorsLightAndDark() {
        val light = lightValiantColors()
        val dark = darkValiantColors()

        assertEquals(Color(0xFF0485F7), light.primary.color)
        assertEquals(Color(0xFF0485F7), dark.primary.color)

        assertEquals(Color(0xFFFF383C), light.danger.color)
        assertEquals(Color(0xFFDB3B3E), dark.danger.color)

        assertEquals(Color(0xFF17C964), light.success.color)
        assertEquals(Color(0xFF17C964), dark.success.color)

        assertEquals(Color(0xFFF5A524), light.warning.color)
        assertEquals(Color(0xFFF7B750), dark.warning.color)

        assertTrue(dark.isDark)
        assertEquals(Color(0xFF060607), dark.background)
        assertEquals(Color(0xFFF5F5F5), light.background)

        assertEquals(light.primary, light.forRole(ValiantColorRole.Primary))
        assertEquals(light.accent, light.forRole(ValiantColorRole.Accent))
        assertEquals(dark.danger, dark.forRole(ValiantColorRole.Danger))

        // HeroUI v3 Tokens
        assertEquals(light.accent, light.primary)
        assertEquals(light.surface, light.content1)
        assertEquals(Color(0xFFFFFFFF), light.surface)
        assertEquals(Color(0xFF18181B), dark.surface)
        assertEquals(Color(0xFFFFFFFF), light.fieldBackground)
        assertEquals(Color(0xFF18181B), dark.fieldBackground)
    }
}
