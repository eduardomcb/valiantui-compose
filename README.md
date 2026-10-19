# ValiantUI Compose

Kotlin Multiplatform UI design system and component library built with Compose Multiplatform, targeting Android, Desktop (JVM), Web (Wasm/JS), and iOS.

## Modules

- `:core:theme` - Design tokens: theme provider (`ValiantTheme`), colors, typography, radius, shapes, and spacing.
- `:core:interaction` - Interaction modifiers including press-scale spring animations and pointer cursors.
- `:components` - Design system components (`Button`, `ButtonGroup`, `Spinner`, etc.).
- `:catalog` - Interactive multiplatform catalog showcasing components and variants.
- `:androidApp` - Android application runner.
- `:desktopApp` - Desktop (JVM) application runner.
- `:webApp` - Web application runner (Wasm and JS).
- `:iosApp` - iOS application runner.

## Running the Catalog

- Desktop app: `./gradlew :desktopApp:run`
- Android app: `./gradlew :androidApp:assembleDebug`
- Web app (Wasm): `./gradlew :webApp:wasmJsBrowserDevelopmentRun`

## Running Tests

- Components tests: `./gradlew :components:jvmTest`