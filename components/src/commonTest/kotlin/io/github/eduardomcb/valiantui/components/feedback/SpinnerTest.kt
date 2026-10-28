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
        val targetSize = SpinnerSize.Lg

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
