package io.github.eduardomcb.valiantui.catalog.preview.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import io.github.eduardomcb.valiantui.catalog.preview.ComponentEntry
import io.github.eduardomcb.valiantui.catalog.preview.ComponentExample
import io.github.eduardomcb.valiantui.components.button.Button
import io.github.eduardomcb.valiantui.components.button.ButtonGroup
import io.github.eduardomcb.valiantui.components.button.ButtonGroupPosition
import io.github.eduardomcb.valiantui.components.button.ButtonSize
import io.github.eduardomcb.valiantui.components.button.ButtonVariant
import io.github.eduardomcb.valiantui.theme.ValiantColorRole
import io.github.eduardomcb.valiantui.theme.ValiantRadius

val ButtonGroupEntry = ComponentEntry(
    id = "button-group",
    name = "ButtonGroup",
    examples = listOf(
        // 1. Default
        ComponentExample(
            id = "default",
            title = "Default"
        ) {
            ButtonGroup(
                variant = ButtonVariant.Solid,
                color = ValiantColorRole.Primary,
                radius = ValiantRadius.Md
            ) {
                Button(onClick = {}, position = ButtonGroupPosition.First) {
                    Text("Years")
                }
                Button(onClick = {}, position = ButtonGroupPosition.Middle) {
                    Text("Months")
                }
                Button(onClick = {}, position = ButtonGroupPosition.Last) {
                    Text("Days")
                }
            }
        },

        // 2. Variants
        ComponentExample(
            id = "variants",
            title = "Variants"
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                ButtonGroup(
                    variant = ButtonVariant.Flat,
                    color = ValiantColorRole.Secondary,
                    radius = ValiantRadius.Full
                ) {
                    Button(onClick = {}, position = ButtonGroupPosition.First) {
                        Text("Left")
                    }
                    Button(onClick = {}, position = ButtonGroupPosition.Middle) {
                        Text("Center")
                    }
                    Button(onClick = {}, position = ButtonGroupPosition.Last) {
                        Text("Right")
                    }
                }

                ButtonGroup(
                    variant = ButtonVariant.Bordered,
                    color = ValiantColorRole.Default,
                    radius = ValiantRadius.Md
                ) {
                    Button(onClick = {}, position = ButtonGroupPosition.First) {
                        Text("1")
                    }
                    Button(onClick = {}, position = ButtonGroupPosition.Middle) {
                        Text("2")
                    }
                    Button(onClick = {}, position = ButtonGroupPosition.Last) {
                        Text("3")
                    }
                }
            }
        },

        // 3. Sizes
        ComponentExample(
            id = "sizes",
            title = "Sizes"
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                ButtonGroup(
                    size = ButtonSize.Sm,
                    color = ValiantColorRole.Primary
                ) {
                    Button(onClick = {}, position = ButtonGroupPosition.First) {
                        Text("Small")
                    }
                    Button(onClick = {}, position = ButtonGroupPosition.Last) {
                        Text("Small")
                    }
                }

                ButtonGroup(
                    size = ButtonSize.Md,
                    color = ValiantColorRole.Primary
                ) {
                    Button(onClick = {}, position = ButtonGroupPosition.First) {
                        Text("Medium")
                    }
                    Button(onClick = {}, position = ButtonGroupPosition.Last) {
                        Text("Medium")
                    }
                }

                ButtonGroup(
                    size = ButtonSize.Lg,
                    color = ValiantColorRole.Primary
                ) {
                    Button(onClick = {}, position = ButtonGroupPosition.First) {
                        Text("Large")
                    }
                    Button(onClick = {}, position = ButtonGroupPosition.Last) {
                        Text("Large")
                    }
                }
            }
        }
    )
)
