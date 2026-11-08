package io.github.eduardomcb.valiantui.catalog.preview.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import io.github.eduardomcb.valiantui.catalog.preview.ComponentEntry
import io.github.eduardomcb.valiantui.catalog.preview.ComponentExample
import io.github.eduardomcb.valiantui.components.feedback.Spinner
import io.github.eduardomcb.valiantui.components.feedback.SpinnerColor
import io.github.eduardomcb.valiantui.components.feedback.SpinnerSize
import io.github.eduardomcb.valiantui.theme.ValiantTheme

val SpinnerEntry = ComponentEntry(
    id = "spinner",
    name = "Spinner",
    examples = listOf(
        // 1. Basic
        ComponentExample(
            id = "default",
            title = "Basic"
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spinner()
            }
        },

        // 2. Colors
        ComponentExample(
            id = "colors",
            title = "Colors"
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Spinner(color = SpinnerColor.Current)
                    Text("Current", style = ValiantTheme.typography.tiny, color = ValiantTheme.colors.muted)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Spinner(color = SpinnerColor.Accent)
                    Text("Accent", style = ValiantTheme.typography.tiny, color = ValiantTheme.colors.muted)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Spinner(color = SpinnerColor.Success)
                    Text("Success", style = ValiantTheme.typography.tiny, color = ValiantTheme.colors.muted)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Spinner(color = SpinnerColor.Warning)
                    Text("Warning", style = ValiantTheme.typography.tiny, color = ValiantTheme.colors.muted)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Spinner(color = SpinnerColor.Danger)
                    Text("Danger", style = ValiantTheme.typography.tiny, color = ValiantTheme.colors.muted)
                }
            }
        },

        // 3. Sizes
        ComponentExample(
            id = "sizes",
            title = "Sizes"
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Spinner(size = SpinnerSize.Sm)
                    Text("Small", style = ValiantTheme.typography.tiny, color = ValiantTheme.colors.muted)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Spinner(size = SpinnerSize.Md)
                    Text("Medium", style = ValiantTheme.typography.tiny, color = ValiantTheme.colors.muted)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Spinner(size = SpinnerSize.Lg)
                    Text("Large", style = ValiantTheme.typography.tiny, color = ValiantTheme.colors.muted)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Spinner(size = SpinnerSize.Xl)
                    Text("Extra Large", style = ValiantTheme.typography.tiny, color = ValiantTheme.colors.muted)
                }
            }
        },

        // 4. Speed
        ComponentExample(
            id = "speed",
            title = "Speed"
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Spinner(durationMillis = 1500)
                    Text("Slow", style = ValiantTheme.typography.tiny, color = ValiantTheme.colors.muted)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Spinner(durationMillis = 800)
                    Text("Default", style = ValiantTheme.typography.tiny, color = ValiantTheme.colors.muted)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Spinner(durationMillis = 400)
                    Text("Fast", style = ValiantTheme.typography.tiny, color = ValiantTheme.colors.muted)
                }
            }
        }
    )
)
