package io.github.eduardomcb.valiantui.components.button

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertHeightIsEqualTo
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertWidthIsEqualTo
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.v2.runComposeUiTest
import androidx.compose.ui.unit.dp
import io.github.eduardomcb.valiantui.theme.ValiantTheme
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class ButtonTest {

    @Test
    fun button_whenEnabled_clickTriggersCallback() = runComposeUiTest {
        var clicked = false

        setContent {
            ValiantTheme {
                Button(onClick = { clicked = true }) {
                    Text("Save")
                }
            }
        }

        onNodeWithText("Save").performClick()
        assertTrue(clicked, "Expected onClick to be called when button is enabled")
    }

    @Test
    fun button_whenDisabled_doesNotTriggerCallback() = runComposeUiTest {
        var clicked = false

        setContent {
            ValiantTheme {
                Button(
                    onClick = { clicked = true },
                    isDisabled = true
                ) {
                    Text("Disabled Action")
                }
            }
        }

        val buttonNode = onNodeWithText("Disabled Action")
        buttonNode.assertIsNotEnabled()
        buttonNode.performClick()

        assertFalse(clicked, "Expected onClick NOT to be called when button is disabled")
    }

    @Test
    fun button_whenLoading_doesNotTriggerCallback() = runComposeUiTest {
        var clicked = false

        setContent {
            ValiantTheme {
                Button(
                    onClick = { clicked = true },
                    isLoading = true
                ) {
                    Text("Submitting")
                }
            }
        }

        onNodeWithText("Submitting").performClick()
        assertFalse(clicked, "Expected onClick NOT to be called when button is loading")
    }

    @Test
    fun button_whenLoading_hidesStartAndEndContent() = runComposeUiTest {
        setContent {
            ValiantTheme {
                Button(
                    onClick = {},
                    isLoading = true,
                    startContent = { Text("StartIcon") },
                    endContent = { Text("EndIcon") }
                ) {
                    Text("Loading Button")
                }
            }
        }

        onNodeWithText("Loading Button").assertIsDisplayed()
        onNodeWithText("StartIcon").assertDoesNotExist()
        onNodeWithText("EndIcon").assertDoesNotExist()
    }

    @Test
    fun button_whenNotLoading_rendersStartAndEndContent() = runComposeUiTest {
        setContent {
            ValiantTheme {
                Button(
                    onClick = {},
                    isLoading = false,
                    startContent = { Text("StartIcon") },
                    endContent = { Text("EndIcon") }
                ) {
                    Text("Button Content")
                }
            }
        }

        onNodeWithText("StartIcon").assertIsDisplayed()
        onNodeWithText("Button Content").assertIsDisplayed()
        onNodeWithText("EndIcon").assertIsDisplayed()
    }

    @Test
    fun button_exposesButtonSemanticsRole() = runComposeUiTest {
        setContent {
            ValiantTheme {
                Button(onClick = {}) {
                    Text("Accessible Button")
                }
            }
        }

        onNodeWithText("Accessible Button")
            .assert(SemanticsMatcher.expectValue(SemanticsProperties.Role, Role.Button))
    }

    @Test
    fun button_fullWidth_stretchesToContainerWidth() = runComposeUiTest {
        val containerWidth = 320.dp

        setContent {
            ValiantTheme {
                Box(modifier = Modifier.width(containerWidth)) {
                    Button(
                        onClick = {},
                        fullWidth = true,
                        modifier = Modifier.testTag("full_width_button")
                    ) {
                        Text("Full Width")
                    }
                }
            }
        }

        onNodeWithTag("full_width_button").assertWidthIsEqualTo(containerWidth)
    }

    @Test
    fun button_isIconOnly_rendersSquareDimensions() = runComposeUiTest {
        val size = ButtonSize.Md

        setContent {
            ValiantTheme {
                Button(
                    onClick = {},
                    size = size,
                    isIconOnly = true,
                    modifier = Modifier.testTag("icon_only_button")
                ) {
                    Text("+")
                }
            }
        }

        onNodeWithTag("icon_only_button")
            .assertWidthIsEqualTo(size.height)
            .assertHeightIsEqualTo(size.height)
    }
}
