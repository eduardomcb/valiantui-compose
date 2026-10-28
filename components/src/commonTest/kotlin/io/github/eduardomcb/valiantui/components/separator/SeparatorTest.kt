package io.github.eduardomcb.valiantui.components.separator

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.v2.runComposeUiTest
import androidx.compose.ui.unit.dp
import io.github.eduardomcb.valiantui.theme.ValiantTheme
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class SeparatorTest {

    @Test
    fun separator_withText_rendersTextCorrectly() = runComposeUiTest {
        setContent {
            ValiantTheme {
                Separator(
                    text = "OR",
                    orientation = SeparatorOrientation.Horizontal
                )
            }
        }

        onNodeWithText("OR").assertIsDisplayed()
    }

    @Test
    fun separator_withCustomLabelSlot_takesPrecedenceOverText() = runComposeUiTest {
        setContent {
            ValiantTheme {
                Separator(
                    text = "Fallback Text",
                    label = { Text("Custom Slot Label") }
                )
            }
        }

        onNodeWithText("Custom Slot Label").assertIsDisplayed()
        onNodeWithText("Fallback Text").assertDoesNotExist()
    }

    @Test
    fun separator_horizontal_rendersLineWithoutCrashing() = runComposeUiTest {
        setContent {
            ValiantTheme {
                Box(modifier = Modifier.width(200.dp)) {
                    Separator(
                        orientation = SeparatorOrientation.Horizontal,
                        modifier = Modifier.testTag("horizontal_separator")
                    )
                }
            }
        }

        onNodeWithTag("horizontal_separator").assertIsDisplayed()
    }

    @Test
    fun separator_vertical_rendersLineWithoutCrashing() = runComposeUiTest {
        setContent {
            ValiantTheme {
                Box(modifier = Modifier.height(200.dp)) {
                    Separator(
                        orientation = SeparatorOrientation.Vertical,
                        modifier = Modifier.testTag("vertical_separator")
                    )
                }
            }
        }

        onNodeWithTag("vertical_separator").assertIsDisplayed()
    }
}
