# Interactions & Micro-animations

The `:core:interaction` module provides specialized modifiers for tactile feedback and cross-platform cursor adaptations.

---

## Spring Press Scaling (`pressScale`)

Interactive elements scale down slightly (to 97% of their natural size) on press using a physics-driven `Spring` animation:

### Usage

```kotlin
val interactionSource = remember { MutableInteractionSource() }

Box(
    modifier = Modifier
        .clickable(interactionSource = interactionSource, indication = null) { }
        .pressScale(interactionSource = interactionSource, pressedScale = 0.97f)
) {
    // Composable with spring feedback
}
```

### Spring Parameters

- **Pressed Scale:** `0.97f` (contracts by 3% when pressed)
- **Damping Ratio:** `Spring.DampingRatioMediumBouncy`
- **Stiffness:** `Spring.StiffnessMediumLow`

---

## Pointer Cursor (`pointerCursor`)

On Desktop (JVM) and Web (WebAssembly & JS), the `pointerCursor` modifier automatically applies a pointer icon (`PointerIcon.Hand`) when hovering interactive elements:

```kotlin
Modifier.pointerCursor(enabled = true)
```
