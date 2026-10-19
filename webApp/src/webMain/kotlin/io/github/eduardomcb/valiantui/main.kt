package io.github.eduardomcb.valiantui

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import io.github.eduardomcb.valiantui.catalog.CatalogApp

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport {
        CatalogApp()
    }
}