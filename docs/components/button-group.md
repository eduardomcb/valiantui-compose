# Button Group

`ButtonGroup` connects multiple buttons together into a single cohesive control, managing shared styling, collapsed inner borders, and merged corner radii.

---

## Default

<iframe 
    title="ButtonGroup Default Preview" 
    src="../compose/index.html?component=button-group&example=default" 
    style="width: 100%; height: 150px; border: 1px solid var(--md-default-fg-color--lightest); border-radius: 12px; background: transparent;" 
    loading="lazy">
</iframe>

```kotlin
ButtonGroup(
    variant = ButtonVariant.Solid,
    color = ValiantColorRole.Primary,
    radius = ValiantRadius.Md
) {
    Button(onClick = {}, position = ButtonGroupPosition.First) { Text("Years") }
    Button(onClick = {}, position = ButtonGroupPosition.Middle) { Text("Months") }
    Button(onClick = {}, position = ButtonGroupPosition.Last) { Text("Days") }
}
```

---

## Examples

### Variants

<iframe 
    title="ButtonGroup Variants Preview" 
    src="../compose/index.html?component=button-group&example=variants" 
    style="width: 100%; height: 210px; border: 1px solid var(--md-default-fg-color--lightest); border-radius: 12px; background: transparent;" 
    loading="lazy">
</iframe>

```kotlin
// Flat variant with pill radius
ButtonGroup(
    variant = ButtonVariant.Flat,
    color = ValiantColorRole.Secondary,
    radius = ValiantRadius.Full
) {
    Button(onClick = {}, position = ButtonGroupPosition.First) { Text("Left") }
    Button(onClick = {}, position = ButtonGroupPosition.Middle) { Text("Center") }
    Button(onClick = {}, position = ButtonGroupPosition.Last) { Text("Right") }
}

// Bordered variant with collapsed borders
ButtonGroup(
    variant = ButtonVariant.Bordered,
    color = ValiantColorRole.Default,
    radius = ValiantRadius.Md
) {
    Button(onClick = {}, position = ButtonGroupPosition.First) { Text("1") }
    Button(onClick = {}, position = ButtonGroupPosition.Middle) { Text("2") }
    Button(onClick = {}, position = ButtonGroupPosition.Last) { Text("3") }
}
```

---

### Sizes

<iframe 
    title="ButtonGroup Sizes Preview" 
    src="../compose/index.html?component=button-group&example=sizes" 
    style="width: 100%; height: 250px; border: 1px solid var(--md-default-fg-color--lightest); border-radius: 12px; background: transparent;" 
    loading="lazy">
</iframe>

```kotlin
ButtonGroup(size = ButtonSize.Sm, color = ValiantColorRole.Primary) {
    Button(onClick = {}, position = ButtonGroupPosition.First) { Text("Small") }
    Button(onClick = {}, position = ButtonGroupPosition.Last) { Text("Small") }
}

ButtonGroup(size = ButtonSize.Md, color = ValiantColorRole.Primary) {
    Button(onClick = {}, position = ButtonGroupPosition.First) { Text("Medium") }
    Button(onClick = {}, position = ButtonGroupPosition.Last) { Text("Medium") }
}

ButtonGroup(size = ButtonSize.Lg, color = ValiantColorRole.Primary) {
    Button(onClick = {}, position = ButtonGroupPosition.First) { Text("Large") }
    Button(onClick = {}, position = ButtonGroupPosition.Last) { Text("Large") }
}
```

---

## API Reference

### ButtonGroup Parameters

| Property | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `variant` | `ButtonVariant` | `ButtonVariant.Solid` | Default variant inherited by child buttons |
| `color` | `ValiantColorRole` | `ValiantColorRole.Default` | Default color role inherited by child buttons |
| `size` | `ButtonSize` | `ButtonSize.Md` | Height and padding inherited by child buttons |
| `radius` | `ValiantRadius` | `ValiantRadius.Md` | Corner radius applied to the outer edges of the group |
| `isDisabled` | `Boolean` | `false` | Disables all child buttons in the group |
| `content` | `@Composable ButtonGroupScope.() -> Unit` | **Required** | Content block where child buttons are declared |

### ButtonGroupPosition

Child buttons declare their placement within the group using `ButtonGroupPosition`:

- `ButtonGroupPosition.Single`: Standalone button with rounded corners on all sides.
- `ButtonGroupPosition.First`: Left-most button with rounded left corners only.
- `ButtonGroupPosition.Middle`: Intermediate button with square corners on all sides and collapsed borders.
- `ButtonGroupPosition.Last`: Right-most button with rounded right corners only.
