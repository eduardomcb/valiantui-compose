package io.github.eduardomcb.valiantui.catalog.preview.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import io.github.eduardomcb.valiantui.catalog.preview.ComponentEntry
import io.github.eduardomcb.valiantui.catalog.preview.ComponentExample
import io.github.eduardomcb.valiantui.components.button.Button
import io.github.eduardomcb.valiantui.components.button.ButtonVariant
import io.github.eduardomcb.valiantui.components.separator.Separator
import io.github.eduardomcb.valiantui.components.separator.SeparatorOrientation
import io.github.eduardomcb.valiantui.components.separator.SeparatorVariant
import io.github.eduardomcb.valiantui.theme.ValiantColorRole
import io.github.eduardomcb.valiantui.theme.ValiantTheme

val SeparatorEntry = ComponentEntry(
    id = "separator",
    name = "Separator",
    examples = listOf(
        // 1. Horizontal
        ComponentExample(
            id = "default",
            title = "Horizontal"
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("Item Superior", style = ValiantTheme.typography.small)
                Separator()
                Text("Item Inferior", style = ValiantTheme.typography.small)
            }
        },

        // 2. Vertical
        ComponentExample(
            id = "vertical",
            title = "Vertical"
        ) {
            Row(
                modifier = Modifier.height(24.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Início", style = ValiantTheme.typography.small)
                Separator(orientation = SeparatorOrientation.Vertical)
                Text("Docs", style = ValiantTheme.typography.small)
                Separator(orientation = SeparatorOrientation.Vertical)
                Text("GitHub", style = ValiantTheme.typography.small)
            }
        },

        // 3. Com Rótulo / Label
        ComponentExample(
            id = "with-label",
            title = "With Label"
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(onClick = {}, color = ValiantColorRole.Primary, fullWidth = true) {
                    Text("Continuar com Google")
                }
                Separator(text = "OU", variant = SeparatorVariant.Secondary)
                Button(onClick = {}, variant = ButtonVariant.Bordered, color = ValiantColorRole.Default, fullWidth = true) {
                    Text("Continuar com E-mail")
                }
            }
        }
    )
)
