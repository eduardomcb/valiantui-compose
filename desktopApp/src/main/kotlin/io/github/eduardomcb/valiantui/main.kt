package io.github.eduardomcb.valiantui

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.github.eduardomcb.valiantui.catalog.CatalogApp

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "ValiantUI Compose Catalog",
    ) {
        CatalogApp()
    }
}