package io.github.eduardomcb.valiantui.catalog.preview.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import io.github.eduardomcb.valiantui.catalog.preview.ComponentEntry
import io.github.eduardomcb.valiantui.catalog.preview.ComponentExample
import io.github.eduardomcb.valiantui.components.feedback.Spinner
import io.github.eduardomcb.valiantui.components.feedback.SpinnerSize
import io.github.eduardomcb.valiantui.theme.ValiantColorRole

val SpinnerEntry = ComponentEntry(
    id = "spinner",
    name = "Spinner",
    examples = listOf(
        // 1. Sizes
        ComponentExample(
            id = "sizes",
            title = "Sizes"
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spinner(size = SpinnerSize.Sm)
                Spinner(size = SpinnerSize.Md)
                Spinner(size = SpinnerSize.Lg)
            }
        },

        // 2. Colors
        ComponentExample(
            id = "colors",
            title = "Colors"
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spinner(colorRole = ValiantColorRole.Primary)
                Spinner(colorRole = ValiantColorRole.Secondary)
                Spinner(colorRole = ValiantColorRole.Success)
                Spinner(colorRole = ValiantColorRole.Warning)
                Spinner(colorRole = ValiantColorRole.Danger)
            }
        }
    )
)
