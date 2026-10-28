package io.github.eduardomcb.valiantui.components.button

import androidx.compose.material3.Text
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.v2.runComposeUiTest
import io.github.eduardomcb.valiantui.theme.ValiantTheme
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class ButtonGroupTest {

    @Test
    fun buttonGroup_rendersAllButtonsAndHandlesClicks() = runComposeUiTest {
        var firstClicked = false
        var secondClicked = false
        var thirdClicked = false

        setContent {
            ValiantTheme {
                ButtonGroup {
                    Button(
                        onClick = { firstClicked = true },
                        position = ButtonGroupPosition.First
                    ) {
                        Text("Left")
                    }
                    Button(
                        onClick = { secondClicked = true },
                        position = ButtonGroupPosition.Middle
                    ) {
                        Text("Center")
                    }
                    Button(
                        onClick = { thirdClicked = true },
                        position = ButtonGroupPosition.Last
                    ) {
                        Text("Right")
                    }
                }
            }
        }

        onNodeWithText("Left").performClick()
        assertTrue(firstClicked, "Left button should trigger its onClick")

        onNodeWithText("Center").performClick()
        assertTrue(secondClicked, "Center button should trigger its onClick")

        onNodeWithText("Right").performClick()
        assertTrue(thirdClicked, "Right button should trigger its onClick")
    }

    @Test
    fun buttonGroup_whenDisabled_propagatesDisabledStateToChildren() = runComposeUiTest {
        var clicked = false

        setContent {
            ValiantTheme {
                ButtonGroup(isDisabled = true) {
                    Button(
                        onClick = { clicked = true },
                        position = ButtonGroupPosition.Single
                    ) {
                        Text("Group Disabled Button")
                    }
                }
            }
        }

        val node = onNodeWithText("Group Disabled Button")
        node.assertIsNotEnabled()
        node.performClick()

        assertFalse(clicked, "Disabled button group should prevent child button click")
    }

    @Test
    fun buttonGroup_childCanOverrideGroupDisabledState() = runComposeUiTest {
        var clicked = false

        setContent {
            ValiantTheme {
                ButtonGroup(isDisabled = true) {
                    Button(
                        onClick = { clicked = true },
                        position = ButtonGroupPosition.Single,
                        isDisabled = false
                    ) {
                        Text("Enabled Override")
                    }
                }
            }
        }

        onNodeWithText("Enabled Override").performClick()
        assertTrue(clicked, "Explicitly enabled button should trigger its onClick even in disabled group")
    }
}
