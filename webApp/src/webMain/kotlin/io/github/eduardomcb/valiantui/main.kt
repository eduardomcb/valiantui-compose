package io.github.eduardomcb.valiantui

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import io.github.eduardomcb.valiantui.catalog.preview.StandalonePreviewApp
import kotlinx.browser.window

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val search = window.location.search.removePrefix("?")
    val params = if (search.isNotBlank()) {
        search.split("&").filter { it.contains("=") }.associate {
            val parts = it.split("=", limit = 2)
            parts[0].lowercase() to parts[1]
        }
    } else {
        emptyMap()
    }

    val componentId = params["component"]
    val exampleId = params["example"]
    val themeParam = params["theme"]

    ComposeViewport {
        StandalonePreviewApp(
            componentId = componentId,
            exampleId = exampleId,
            themeParam = themeParam
        )
    }
}
