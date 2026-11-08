package io.github.eduardomcb.valiantui.components.feedback

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertHeightIsEqualTo
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertWidthIsEqualTo
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.v2.runComposeUiTest
import io.github.eduardomcb.valiantui.theme.ValiantTheme
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class SpinnerTest {

    @Test
    fun spinner_rendersWithExpectedSizeDimensions() = runComposeUiTest {
        val targetSize = SpinnerSize.Xl

        setContent {
            ValiantTheme {
                Spinner(
                    size = targetSize,
                    modifier = Modifier.testTag("spinner_target")
                )
            }
        }

        onNodeWithTag("spinner_target")
            .assertIsDisplayed()
            .assertWidthIsEqualTo(targetSize.size)
            .assertHeightIsEqualTo(targetSize.size)
    }

    @Test
    fun spinner_withHeroUiColor_rendersWithoutCrashing() = runComposeUiTest {
        setContent {
            ValiantTheme {
                Spinner(
                    color = SpinnerColor.Current,
                    modifier = Modifier.testTag("heroui_color_spinner")
                )
            }
        }

        onNodeWithTag("heroui_color_spinner").assertIsDisplayed()
    }

    @Test
    fun testSvgPathParsing() {
        val p1 = androidx.compose.ui.graphics.vector.PathParser().parsePathString(
            "M8.749.021a1.5 1.5 0 0 1 .497 2.958A7.5 7.5 0 0 0 3 10.375a7.5 7.5 0 0 0 7.5 7.5v3c-5.799 0-10.5-4.7-10.5-10.5C0 5.23 3.726.865 8.749.021"
        ).toPath()
        val p2 = androidx.compose.ui.graphics.vector.PathParser().parsePathString(
            "M15.392 2.673a1.5 1.5 0 0 1 2.119-.115A10.48 10.48 0 0 1 21 10.375c0 5.8-4.701 10.5-10.5 10.5v-3a7.5 7.5 0 0 0 5.007-13.084a1.5 1.5 0 0 1-.115-2.118"
        ).toPath()
        val b1 = androidx.compose.ui.graphics.Brush.linearGradient(
            listOf(Color.Blue, Color.Blue.copy(alpha = 0.55f)),
            start = androidx.compose.ui.geometry.Offset(5.25f, 1.1016f),
            end = androidx.compose.ui.geometry.Offset(5.25f, 19.1847f)
        )
        val b2 = androidx.compose.ui.graphics.Brush.linearGradient(
            listOf(Color.Blue.copy(alpha = 0f), Color.Blue.copy(alpha = 0.55f)),
            start = androidx.compose.ui.geometry.Offset(15.75f, 5.05f),
            end = androidx.compose.ui.geometry.Offset(15.75f, 18.50f)
        )
        kotlin.test.assertNotNull(p1)
        kotlin.test.assertNotNull(p2)
        kotlin.test.assertNotNull(b1)
        kotlin.test.assertNotNull(b2)
    }

    @Test
    fun spinner_withCustomColors_rendersWithoutCrashing() = runComposeUiTest {
        setContent {
            ValiantTheme {
                Spinner(
                    color = Color.Red,
                    trackColor = Color.Gray,
                    modifier = Modifier.testTag("custom_color_spinner")
                )
            }
        }

        onNodeWithTag("custom_color_spinner").assertIsDisplayed()
    }
}
