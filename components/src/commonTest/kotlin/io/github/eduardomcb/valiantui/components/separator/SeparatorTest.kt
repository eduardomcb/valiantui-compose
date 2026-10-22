package io.github.eduardomcb.valiantui.components.separator

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.github.eduardomcb.valiantui.theme.darkValiantColors
import io.github.eduardomcb.valiantui.theme.lightValiantColors
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class SeparatorTest {

    @Test
    fun testSeparatorDefaults() {
        assertEquals(1.dp, SeparatorDefaults.Thickness)
        assertEquals(12.dp, SeparatorDefaults.LabelPadding)
    }

    @Test
    fun testSeparatorVariantsExist() {
        val variants = SeparatorVariant.values()
        assertEquals(3, variants.size)
        assertEquals(SeparatorVariant.Default, variants[0])
        assertEquals(SeparatorVariant.Secondary, variants[1])
        assertEquals(SeparatorVariant.Tertiary, variants[2])
    }

    @Test
    fun testSeparatorOrientationsExist() {
        val orientations = SeparatorOrientation.values()
        assertEquals(2, orientations.size)
        assertEquals(SeparatorOrientation.Horizontal, orientations[0])
        assertEquals(SeparatorOrientation.Vertical, orientations[1])
    }

    @Test
    fun testColorContrastLevelsInLightMode() {
        val lightColors = lightValiantColors()
        val defaultColor = lightColors.separator
        val secondaryColor = lightColors.separatorSecondary
        val tertiaryColor = lightColors.separatorTertiary

        assertNotEquals(defaultColor, secondaryColor)
        assertNotEquals(secondaryColor, tertiaryColor)
        assertEquals(Color(0xFFE4E4E7), defaultColor)
        assertEquals(Color(0xFFDCDCE0), secondaryColor)
        assertEquals(Color(0xFFD4D4D8), tertiaryColor)
        assertEquals(lightColors.separator, lightColors.divider)
    }

    @Test
    fun testColorContrastLevelsInDarkMode() {
        val darkColors = darkValiantColors()
        val defaultColor = darkColors.separator
        val secondaryColor = darkColors.separatorSecondary
        val tertiaryColor = darkColors.separatorTertiary

        assertNotEquals(defaultColor, secondaryColor)
        assertNotEquals(secondaryColor, tertiaryColor)
        assertEquals(Color(0xFF212124), defaultColor)
        assertEquals(Color(0xFF333336), secondaryColor)
        assertEquals(Color(0xFF404044), tertiaryColor)
        assertEquals(darkColors.separator, darkColors.divider)
    }
}
