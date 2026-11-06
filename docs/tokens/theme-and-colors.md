# Theme & Colors

The **ValiantUI Compose** color system provides a cohesive, accessible set of semantic colors designed for high contrast and seamless Light and Dark mode transitions.

---

## ValiantTheme Provider

`ValiantTheme` exposes static `CompositionLocal` providers designed for performance and predictable recomposition:

```kotlin
@Composable
fun AppContent() {
    ValiantTheme(darkTheme = false) {
        val colors = ValiantTheme.colors
        val typography = ValiantTheme.typography
        val radius = ValiantTheme.defaultRadius

        // Access tokens directly
    }
}
```

---

## Semantic Color Roles (`ValiantColorRole`)

Interactive components (such as `Button`, `ButtonGroup`, and `Spinner`) accept the `ValiantColorRole` enum to determine their semantic intent:

| Role | Description | Typical Use Case |
| :--- | :--- | :--- |
| `Default` | Neutral base | Secondary actions, subtle controls |
| `Primary` / `Accent` | Main brand color | Primary call-to-action (CTA) |
| `Secondary` | Purple/indigo complement | Distinct alternate actions |
| `Success` | Emerald green | Confirmations, positive status |
| `Warning` | Amber yellow | Cautionary actions, warnings |
| `Danger` | Crimson red | Destructive actions, error feedback |

---

## Light and Dark Modes

The theme provides predefined color palettes through `lightValiantColors()` and `darkValiantColors()`:

```kotlin
var isDark by remember { mutableStateOf(false) }

ValiantTheme(
    darkTheme = isDark,
    colors = if (isDark) darkValiantColors() else lightValiantColors()
) {
    // Dynamic theme switching
}
```

---

## Surface and Canvas Tokens

Beyond action roles, `ValiantColors` defines semantic background and border layers:

- `background`: Root canvas background.
- `backgroundSecondary`: Secondary background layer for grouped content.
- `surface`: Elevated cards, dialogs, and popovers.
- `surfaceSecondary`: Nested surface layers.
- `divider`: Subtle boundaries and separators.
