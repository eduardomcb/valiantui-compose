package io.github.eduardomcb.valiantui.catalog.preview

import io.github.eduardomcb.valiantui.catalog.preview.components.ButtonEntry
import io.github.eduardomcb.valiantui.catalog.preview.components.ButtonGroupEntry
import io.github.eduardomcb.valiantui.catalog.preview.components.SeparatorEntry
import io.github.eduardomcb.valiantui.catalog.preview.components.SpinnerEntry

/**
 * Central registry mapping component IDs and individual examples.
 */
object PreviewRegistry {
    private val rawEntries: List<ComponentEntry> = listOf(
        ButtonEntry,
        ButtonGroupEntry,
        SeparatorEntry,
        SpinnerEntry
    )

    val entries: Map<String, ComponentEntry> = buildMap {
        rawEntries.forEach { entry ->
            put(entry.id.lowercase(), entry)
            // Register normalized alias without hyphens (e.g. "buttongroup" -> "button-group")
            val noHyphen = entry.id.replace("-", "").lowercase()
            if (noHyphen != entry.id.lowercase()) {
                put(noHyphen, entry)
            }
        }
    }

    fun all(): List<ComponentEntry> = rawEntries

    fun getEntry(componentId: String?): ComponentEntry? {
        if (componentId == null) return null
        return entries[componentId.trim().lowercase()]
    }

    fun find(componentId: String?, exampleId: String? = null): ComponentExample? {
        val entry = getEntry(componentId) ?: return null
        if (exampleId == null || exampleId.isBlank()) {
            return entry.examples.firstOrNull()
        }
        val targetId = exampleId.trim().lowercase()
        return entry.examples.firstOrNull { it.id.lowercase() == targetId }
    }
}
