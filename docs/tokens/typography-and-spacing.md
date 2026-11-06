# Typography & Spacing

---

## Typography (`ValiantTypography`)

The typographic hierarchy provides consistent scales for headers, body content, and labels:

```kotlin
Text(
    text = "Headline",
    style = ValiantTheme.typography.h1
)
```

### Typographic Scale

| Token | Style | Recommended Use |
| :--- | :--- | :--- |
| `h1` | Extra Large | Main screen titles |
| `h2` | Large | Major section titles |
| `h3` | Medium Large | Card and modal headers |
| `h4` | Base Bold | Subsection headers |
| `body` | Regular | Primary paragraph text |
| `small` | 14sp | Button labels, list descriptions |
| `tiny` | 12sp | Badges, captions, helper text |

---

## Spacing (`ValiantSpacing`)

Spacings are normalized around a standard 4dp grid:

- `ValiantSpacing.xs` (4dp)
- `ValiantSpacing.sm` (8dp)
- `ValiantSpacing.md` (16dp)
- `ValiantSpacing.lg` (24dp)
- `ValiantSpacing.xl` (32dp)

---

## Corner Radius (`ValiantRadius`)

The `ValiantRadius` enum defines border curves for buttons, cards, and modal dialogs:

| Value | Radius |
| :--- | :--- |
| `None` | `0.dp` |
| `Sm` | `8.dp` |
| `Md` | `12.dp` (Default) |
| `Lg` | `16.dp` |
| `Full` | Fully rounded pill shape |
