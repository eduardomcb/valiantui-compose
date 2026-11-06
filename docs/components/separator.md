# Separator

The `Separator` component visually divides sections of content, list items, navigation links, or form actions.

---

## Default (Horizontal)

<iframe 
    title="Separator Default Preview" 
    src="../../compose/index.html?component=separator&example=default" 
    style="width: 100%; height: 160px; border: 1px solid var(--md-default-fg-color--lightest); border-radius: 12px; background: transparent;" 
    loading="lazy">
</iframe>

```kotlin
Text("Top Content")
Separator()
Text("Bottom Content")
```

---

## Examples

### Vertical

<iframe 
    title="Separator Vertical Preview" 
    src="../../compose/index.html?component=separator&example=vertical" 
    style="width: 100%; height: 140px; border: 1px solid var(--md-default-fg-color--lightest); border-radius: 12px; background: transparent;" 
    loading="lazy">
</iframe>

```kotlin
Row(
    modifier = Modifier.height(24.dp),
    horizontalArrangement = Arrangement.spacedBy(12.dp),
    verticalAlignment = Alignment.CenterVertically
) {
    Text("Home")
    Separator(orientation = SeparatorOrientation.Vertical)
    Text("Docs")
    Separator(orientation = SeparatorOrientation.Vertical)
    Text("GitHub")
}
```

---

### With Centered Label

<iframe 
    title="Separator With Label Preview" 
    src="../../compose/index.html?component=separator&example=with-label" 
    style="width: 100%; height: 210px; border: 1px solid var(--md-default-fg-color--lightest); border-radius: 12px; background: transparent;" 
    loading="lazy">
</iframe>

```kotlin
Button(onClick = { }, fullWidth = true) {
    Text("Continue with Google")
}

Separator(text = "OR", variant = SeparatorVariant.Secondary)

Button(onClick = { }, variant = ButtonVariant.Bordered, color = ValiantColorRole.Default, fullWidth = true) {
    Text("Continue with Email")
}
```

---

## API Reference

| Property | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `orientation` | `SeparatorOrientation` | `Horizontal` | `Horizontal` or `Vertical` |
| `variant` | `SeparatorVariant` | `Default` | `Default` (subtle), `Secondary` (medium), `Tertiary` (high contrast) |
| `text` | `String?` | `null` | Optional centered label with flanking divider lines |
| `thickness` | `Dp` | `1.dp` | Stroke thickness of the divider |
