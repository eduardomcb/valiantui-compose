# Button

Buttons trigger actions or events on the user interface. ValiantUI buttons support multiple visual variants, sizes, loading states, and icon slots with spring press-scaling feedback.

---

## Default

<iframe 
    title="Button Default Preview" 
    src="../compose/index.html?component=button&example=default" 
    style="width: 100%; height: 150px; border: 1px solid var(--md-default-fg-color--lightest); border-radius: 12px; background: transparent;" 
    loading="lazy">
</iframe>

```kotlin
Button(
    onClick = { },
    color = ValiantColorRole.Primary
) {
    Text("Button")
}
```

---

## Examples

### Disabled

<iframe 
    title="Button Disabled Preview" 
    src="../compose/index.html?component=button&example=disabled" 
    style="width: 100%; height: 150px; border: 1px solid var(--md-default-fg-color--lightest); border-radius: 12px; background: transparent;" 
    loading="lazy">
</iframe>

```kotlin
Button(
    onClick = { },
    color = ValiantColorRole.Primary,
    isDisabled = true
) {
    Text("Disabled")
}
```

---

### Sizes

<iframe 
    title="Button Sizes Preview" 
    src="../compose/index.html?component=button&example=sizes" 
    style="width: 100%; height: 160px; border: 1px solid var(--md-default-fg-color--lightest); border-radius: 12px; background: transparent;" 
    loading="lazy">
</iframe>

```kotlin
Button(onClick = {}, size = ButtonSize.Sm) { Text("Small") }
Button(onClick = {}, size = ButtonSize.Md) { Text("Medium") }
Button(onClick = {}, size = ButtonSize.Lg) { Text("Large") }
```

---

### Colors

<iframe 
    title="Button Colors Preview" 
    src="../compose/index.html?component=button&example=colors" 
    style="width: 100%; height: 180px; border: 1px solid var(--md-default-fg-color--lightest); border-radius: 12px; background: transparent;" 
    loading="lazy">
</iframe>

```kotlin
ValiantColorRole.entries.forEach { role ->
    Button(onClick = {}, color = role) {
        Text(role.name)
    }
}
```

---

### Variants

<iframe 
    title="Button Variants Preview" 
    src="../compose/index.html?component=button&example=variants" 
    style="width: 100%; height: 180px; border: 1px solid var(--md-default-fg-color--lightest); border-radius: 12px; background: transparent;" 
    loading="lazy">
</iframe>

```kotlin
ButtonVariant.entries.forEach { variant ->
    Button(
        onClick = {},
        variant = variant,
        color = ValiantColorRole.Primary
    ) {
        Text(variant.name)
    }
}
```

---

### Loading

<iframe 
    title="Button Loading Preview" 
    src="../compose/index.html?component=button&example=loading" 
    style="width: 100%; height: 150px; border: 1px solid var(--md-default-fg-color--lightest); border-radius: 12px; background: transparent;" 
    loading="lazy">
</iframe>

```kotlin
Button(
    onClick = { },
    isLoading = true,
    color = ValiantColorRole.Primary
) {
    Text("Action")
}
```

---

### With Icons

<iframe 
    title="Button Icons Preview" 
    src="../compose/index.html?component=button&example=icons" 
    style="width: 100%; height: 160px; border: 1px solid var(--md-default-fg-color--lightest); border-radius: 12px; background: transparent;" 
    loading="lazy">
</iframe>

```kotlin
Button(
    onClick = { },
    color = ValiantColorRole.Success,
    startContent = { Text("✓") }
) {
    Text("Success")
}

Button(
    onClick = { },
    variant = ButtonVariant.Bordered,
    color = ValiantColorRole.Primary,
    endContent = { Text("→") }
) {
    Text("Next")
}

Button(
    onClick = { },
    isIconOnly = true,
    radius = ValiantRadius.Full,
    color = ValiantColorRole.Secondary
) {
    Text("+")
}
```

---

## API Reference

| Property | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `onClick` | `() -> Unit` | **Required** | Action triggered when clicked |
| `variant` | `ButtonVariant` | `Solid` | `Solid`, `Faded`, `Bordered`, `Light`, `Flat`, `Ghost`, `Shadow` |
| `color` | `ValiantColorRole` | `Default` | `Default`, `Primary`, `Secondary`, `Success`, `Warning`, `Danger` |
| `size` | `ButtonSize` | `Md` | `Sm` (32dp), `Md` (40dp), `Lg` (48dp) |
| `radius` | `ValiantRadius` | `Md` | `None`, `Sm`, `Md`, `Lg`, `Full` |
| `isDisabled` | `Boolean` | `false` | Disables interaction and reduces opacity |
| `isLoading` | `Boolean` | `false` | Displays a rotating Spinner and blocks interaction |
| `isIconOnly` | `Boolean` | `false` | Adjusts padding for square or circular icon buttons |
| `fullWidth` | `Boolean` | `false` | Extends width to fill the parent container |
| `startContent` | `@Composable () -> Unit` | `null` | Slot for leading icon or composable |
| `endContent` | `@Composable () -> Unit` | `null` | Slot for trailing icon or composable |
