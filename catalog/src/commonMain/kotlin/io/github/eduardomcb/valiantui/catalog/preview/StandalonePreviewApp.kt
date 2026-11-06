package io.github.eduardomcb.valiantui.catalog.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.eduardomcb.valiantui.catalog.CatalogApp
import io.github.eduardomcb.valiantui.theme.ValiantTheme
import io.github.eduardomcb.valiantui.theme.darkValiantColors
import io.github.eduardomcb.valiantui.theme.lightValiantColors

/**
 * Runner de preview isolado para iframes de documentação ou janelas dedicadas.
 */
@Composable
fun StandalonePreviewApp(
    componentId: String?,
    exampleId: String? = null,
    themeParam: String? = null
) {
    val isSystemDark = isSystemInDarkTheme()
    val isDark = when (themeParam?.lowercase()) {
        "dark" -> true
        "light" -> false
        else -> isSystemDark
    }

    val colors = if (isDark) darkValiantColors() else lightValiantColors()

    val example = PreviewRegistry.find(componentId, exampleId)
    val entry = PreviewRegistry.getEntry(componentId)

    if (example != null) {
        // Renderiza apenas o sandbox individual focado, centralizado e sem poluição
        ValiantTheme(darkTheme = isDark, colors = colors) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colors.surface)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                example.content()
            }
        }
    } else if (entry != null) {
        // Renderiza todos os exemplos daquele componente empilhados
        ValiantTheme(darkTheme = isDark, colors = colors) {
            ComponentShowcaseList(entry = entry)
        }
    } else {
        // Se nenhum parâmetro for fornecido, executa o catálogo completo
        CatalogApp()
    }
}

@Composable
private fun ComponentShowcaseList(entry: ComponentEntry) {
    val colors = ValiantTheme.colors
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
            .verticalScroll(scrollState)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = entry.name,
            style = ValiantTheme.typography.h1.copy(fontWeight = FontWeight.Bold),
            color = colors.foreground
        )

        entry.examples.forEach { example ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colors.surface)
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = example.title,
                    style = ValiantTheme.typography.h3,
                    color = colors.foreground
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    example.content()
                }
            }
        }
    }
}
