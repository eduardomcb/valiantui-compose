package io.github.eduardomcb.valiantui.catalog.preview.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.eduardomcb.valiantui.catalog.preview.ComponentEntry
import io.github.eduardomcb.valiantui.catalog.preview.ComponentExample
import io.github.eduardomcb.valiantui.components.button.Button
import io.github.eduardomcb.valiantui.components.button.ButtonGroup
import io.github.eduardomcb.valiantui.components.button.ButtonGroupPosition
import io.github.eduardomcb.valiantui.components.button.ButtonSize
import io.github.eduardomcb.valiantui.components.button.ButtonVariant
import io.github.eduardomcb.valiantui.theme.ValiantColorRole
import io.github.eduardomcb.valiantui.theme.ValiantRadius

@OptIn(ExperimentalLayoutApi::class)
val ButtonEntry = ComponentEntry(
    id = "button",
    name = "Button",
    examples = listOf(
        // 1. Uso Básico (Default)
        ComponentExample(
            id = "default",
            title = "Default"
        ) {
            Button(
                onClick = {},
                color = ValiantColorRole.Primary
            ) {
                Text("Button")
            }
        },

        // 2. Disabled
        ComponentExample(
            id = "disabled",
            title = "Disabled"
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Button(
                    onClick = {},
                    color = ValiantColorRole.Primary,
                    isDisabled = true
                ) {
                    Text("Disabled")
                }
                Button(
                    onClick = {},
                    variant = ButtonVariant.Flat,
                    color = ValiantColorRole.Secondary,
                    isDisabled = true
                ) {
                    Text("Disabled Flat")
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
                Button(onClick = {}, size = ButtonSize.Sm, color = ValiantColorRole.Primary) {
                    Text("Small")
                }
                Button(onClick = {}, size = ButtonSize.Md, color = ValiantColorRole.Primary) {
                    Text("Medium")
                }
                Button(onClick = {}, size = ButtonSize.Lg, color = ValiantColorRole.Primary) {
                    Text("Large")
                }
            }
        },

        // 4. Colors
        ComponentExample(
            id = "colors",
            title = "Colors"
        ) {
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ValiantColorRole.entries.forEach { role ->
                    Button(onClick = {}, color = role) {
                        Text(role.name)
                    }
                }
            }
        },

        // 5. Variants
        ComponentExample(
            id = "variants",
            title = "Variants"
        ) {
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ButtonVariant.entries.forEach { variant ->
                    Button(
                        onClick = {},
                        variant = variant,
                        color = ValiantColorRole.Primary
                    ) {
                        Text(variant.name)
                    }
                }
            }
        },

        // 6. Loading
        ComponentExample(
            id = "loading",
            title = "Loading State"
        ) {
            var isLoading by remember { mutableStateOf(true) }

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { isLoading = !isLoading },
                    color = ValiantColorRole.Primary,
                    isLoading = isLoading
                ) {
                    Text("Action")
                }
                Button(
                    onClick = { isLoading = !isLoading },
                    variant = ButtonVariant.Flat,
                    color = ValiantColorRole.Default,
                    size = ButtonSize.Sm
                ) {
                    Text(if (isLoading) "Pausar" else "Carregar")
                }
            }
        },

        // 7. With Icons
        ComponentExample(
            id = "icons",
            title = "With Icons"
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {},
                    color = ValiantColorRole.Success,
                    startContent = { Text("✓", fontWeight = FontWeight.Bold) }
                ) {
                    Text("Sucesso")
                }
                Button(
                    onClick = {},
                    variant = ButtonVariant.Bordered,
                    color = ValiantColorRole.Primary,
                    endContent = { Text("→", fontWeight = FontWeight.Bold) }
                ) {
                    Text("Próximo")
                }
                Button(
                    onClick = {},
                    isIconOnly = true,
                    radius = ValiantRadius.Full,
                    color = ValiantColorRole.Secondary
                ) {
                    Text("+", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        },

        // 8. Button Group
        ComponentExample(
            id = "group",
            title = "Button Group"
        ) {
            ButtonGroup(
                variant = ButtonVariant.Solid,
                color = ValiantColorRole.Primary,
                radius = ValiantRadius.Md
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
