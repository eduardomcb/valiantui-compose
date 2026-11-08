package io.github.eduardomcb.valiantui.catalog.preview.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.eduardomcb.valiantui.catalog.icons.AppleIcon
import io.github.eduardomcb.valiantui.catalog.icons.EllipsisIcon
import io.github.eduardomcb.valiantui.catalog.icons.EnvelopeIcon
import io.github.eduardomcb.valiantui.catalog.icons.GearIcon
import io.github.eduardomcb.valiantui.catalog.icons.GithubIcon
import io.github.eduardomcb.valiantui.catalog.icons.GlobeIcon
import io.github.eduardomcb.valiantui.catalog.icons.GoogleIcon
import io.github.eduardomcb.valiantui.catalog.icons.PaperclipIcon
import io.github.eduardomcb.valiantui.catalog.icons.PlusIcon
import io.github.eduardomcb.valiantui.catalog.icons.TrashBinIcon
import io.github.eduardomcb.valiantui.catalog.preview.ComponentEntry
import io.github.eduardomcb.valiantui.catalog.preview.ComponentExample
import io.github.eduardomcb.valiantui.components.button.Button
import io.github.eduardomcb.valiantui.components.button.ButtonGroup
import io.github.eduardomcb.valiantui.components.button.ButtonGroupPosition
import io.github.eduardomcb.valiantui.components.button.ButtonSize
import io.github.eduardomcb.valiantui.components.button.ButtonVariant
import io.github.eduardomcb.valiantui.components.feedback.Spinner
import io.github.eduardomcb.valiantui.components.feedback.SpinnerColor
import io.github.eduardomcb.valiantui.components.feedback.SpinnerSize
import io.github.eduardomcb.valiantui.theme.ValiantRadius
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalLayoutApi::class)
val ButtonEntry = ComponentEntry(
    id = "button",
    name = "Button",
    examples = listOf(
        // 1. Basic (Default)
        ComponentExample(
            id = "default",
            title = "Basic"
        ) {
            Button(
                onClick = { println("Button pressed") }
            ) {
                Text("Click me")
            }
        },

        // 2. Variants (HeroUI v3)
        ComponentExample(
            id = "variants",
            title = "Variants"
        ) {
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(onClick = {}) {
                    Text("Primary")
                }
                Button(onClick = {}, variant = ButtonVariant.Secondary) {
                    Text("Secondary")
                }
                Button(onClick = {}, variant = ButtonVariant.Tertiary) {
                    Text("Tertiary")
                }
                Button(onClick = {}, variant = ButtonVariant.Outline) {
                    Text("Outline")
                }
                Button(onClick = {}, variant = ButtonVariant.Ghost) {
                    Text("Ghost")
                }
                Button(onClick = {}, variant = ButtonVariant.Danger) {
                    Text("Danger")
                }
                Button(onClick = {}, variant = ButtonVariant.DangerSoft) {
                    Text("Danger Soft")
                }
            }
        },

        // 3. Sizes
        ComponentExample(
            id = "sizes",
            title = "Sizes"
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = {}, size = ButtonSize.Sm) {
                    Text("Small")
                }
                Button(onClick = {}, size = ButtonSize.Md) {
                    Text("Medium")
                }
                Button(onClick = {}, size = ButtonSize.Lg) {
                    Text("Large")
                }
            }
        },

        // 4. With Icons
        ComponentExample(
            id = "icons",
            title = "With Icons"
        ) {
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(onClick = {}) {
                    GlobeIcon()
                    Text("Search")
                }
                Button(onClick = {}, variant = ButtonVariant.Secondary) {
                    PlusIcon()
                    Text("Add Member")
                }
                Button(onClick = {}, variant = ButtonVariant.Tertiary) {
                    EnvelopeIcon()
                    Text("Email")
                }
                Button(onClick = {}, variant = ButtonVariant.Danger) {
                    TrashBinIcon()
                    Text("Delete")
                }
            }
        },

        // 5. Icon Only
        ComponentExample(
            id = "icon-only",
            title = "Icon Only"
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {},
                    isIconOnly = true,
                    variant = ButtonVariant.Tertiary
                ) {
                    EllipsisIcon()
                }
                Button(
                    onClick = {},
                    isIconOnly = true,
                    variant = ButtonVariant.Secondary
                ) {
                    GearIcon()
                }
                Button(
                    onClick = {},
                    isIconOnly = true,
                    variant = ButtonVariant.Danger
                ) {
                    TrashBinIcon()
                }
            }
        },

        // 6. Loading
        ComponentExample(
            id = "loading",
            title = "Loading"
        ) {
            Button(
                onClick = {},
                isPending = true,
                showDefaultSpinner = false
            ) {
                Spinner(color = SpinnerColor.Current, size = SpinnerSize.Sm)
                Text("Uploading...")
            }
        },

        // 7. Loading State
        ComponentExample(
            id = "loading-state",
            title = "Loading State"
        ) {
            var isLoading by remember { mutableStateOf(false) }
            val coroutineScope = rememberCoroutineScope()

            Button(
                onClick = {
                    if (!isLoading) {
                        isLoading = true
                        coroutineScope.launch {
                            delay(2000)
                            isLoading = false
                        }
                    }
                },
                isPending = isLoading,
                showDefaultSpinner = false
            ) {
                if (isLoading) {
                    Spinner(color = SpinnerColor.Current, size = SpinnerSize.Sm)
                    Text("Uploading...")
                } else {
                    PaperclipIcon()
                    Text("Upload File")
                }
            }
        },

        // 8. Full Width
        ComponentExample(
            id = "full-width",
            title = "Full Width"
        ) {
            Column(
                modifier = Modifier.width(360.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(onClick = {}, fullWidth = true) {
                    Text("Primary Button")
                }
                Button(onClick = {}, fullWidth = true) {
                    PlusIcon()
                    Text("With Icon")
                }
            }
        },

        // 9. Disabled
        ComponentExample(
            id = "disabled",
            title = "Disabled State"
        ) {
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(onClick = {}, isDisabled = true) {
                    Text("Primary")
                }
                Button(onClick = {}, isDisabled = true, variant = ButtonVariant.Secondary) {
                    Text("Secondary")
                }
                Button(onClick = {}, isDisabled = true, variant = ButtonVariant.Tertiary) {
                    Text("Tertiary")
                }
                Button(onClick = {}, isDisabled = true, variant = ButtonVariant.Outline) {
                    Text("Outline")
                }
                Button(onClick = {}, isDisabled = true, variant = ButtonVariant.Ghost) {
                    Text("Ghost")
                }
                Button(onClick = {}, isDisabled = true, variant = ButtonVariant.Danger) {
                    Text("Danger")
                }
            }
        },

        // 10. Social Buttons
        ComponentExample(
            id = "social",
            title = "Social Buttons"
        ) {
            Column(
                modifier = Modifier.width(320.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = {},
                    fullWidth = true,
                    variant = ButtonVariant.Tertiary
                ) {
                    GoogleIcon()
                    Text("Sign in with Google")
                }
                Button(
                    onClick = {},
                    fullWidth = true,
                    variant = ButtonVariant.Tertiary
                ) {
                    GithubIcon()
                    Text("Sign in with GitHub")
                }
                Button(
                    onClick = {},
                    fullWidth = true,
                    variant = ButtonVariant.Tertiary
                ) {
                    AppleIcon()
                    Text("Sign in with Apple")
                }
            }
        },

        // 11. Button Group
        ComponentExample(
            id = "group",
            title = "Button Group"
        ) {
            ButtonGroup(
                variant = ButtonVariant.Primary,
                radius = ValiantRadius.Full
            ) {
                Button(onClick = {}, position = ButtonGroupPosition.First) {
                    Text("Anos")
                }
                Button(onClick = {}, position = ButtonGroupPosition.Middle) {
                    Text("Meses")
                }
                Button(onClick = {}, position = ButtonGroupPosition.Last) {
                    Text("Dias")
                }
            }
        }
    )
)
