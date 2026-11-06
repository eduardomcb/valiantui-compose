# Spinner

The `Spinner` component provides continuous visual feedback during background loading, network requests, or asynchronous task execution.

---

## Default & Sizes

<iframe 
    title="Spinner Sizes Preview" 
    src="../compose/index.html?component=spinner&example=sizes" 
    style="width: 100%; height: 140px; border: 1px solid var(--md-default-fg-color--lightest); border-radius: 12px; background: transparent;" 
    loading="lazy">
</iframe>

```kotlin
Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
    Spinner(size = SpinnerSize.Sm)
    Spinner(size = SpinnerSize.Md)
    Spinner(size = SpinnerSize.Lg)
}
```

---

## Examples

### Colors

<iframe 
    title="Spinner Colors Preview" 
    src="../compose/index.html?component=spinner&example=colors" 
    style="width: 100%; height: 140px; border: 1px solid var(--md-default-fg-color--lightest); border-radius: 12px; background: transparent;" 
    loading="lazy">
</iframe>

```kotlin
Spinner(colorRole = ValiantColorRole.Primary)
Spinner(colorRole = ValiantColorRole.Secondary)
Spinner(colorRole = ValiantColorRole.Success)
Spinner(colorRole = ValiantColorRole.Warning)
Spinner(colorRole = ValiantColorRole.Danger)
```

---

## API Reference

| Property | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `size` | `SpinnerSize` | `Md` | `Sm` (16dp), `Md` (24dp), `Lg` (36dp) |
| `colorRole` | `ValiantColorRole` | `Primary` | Semantic theme role for arc and indicator |
| `color` | `Color?` | `null` | Direct custom color override for the rotating arc |
| `trackColor` | `Color?` | `null` | Direct custom color override for the background ring |
| `strokeWidth` | `Dp?` | `null` | Custom stroke width (defaults to token matching `size`) |
