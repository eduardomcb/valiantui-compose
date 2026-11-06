package io.github.eduardomcb.valiantui.catalog.preview

import androidx.compose.runtime.Composable

/**
 * Representa um exemplo individual focado de um componente (estilo HeroUI sandbox).
 */
data class ComponentExample(
    val id: String,
    val title: String,
    val description: String? = null,
    val content: @Composable () -> Unit
)

/**
 * Representa um componente do catálogo e todos os seus exemplos documentados.
 */
data class ComponentEntry(
    val id: String,
    val name: String,
    val examples: List<ComponentExample>
)
