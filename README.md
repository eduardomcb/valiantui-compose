<div align="center">

# ValiantUI Compose

**A modern UI design system and component library for Compose Multiplatform, inspired by [HeroUI](https://heroui.com/).**

[![Kotlin](https://img.shields.io/badge/Kotlin-Multiplatform-7F52FF?logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Compose Multiplatform](https://img.shields.io/badge/Compose-Multiplatform-4285F4?logo=jetpackcompose&logoColor=white)](https://www.jetbrains.com/compose-multiplatform/)
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](LICENSE)

![Android](https://img.shields.io/badge/Android-3DDC84?style=flat-square&logo=android&logoColor=white)
![iOS](https://img.shields.io/badge/iOS-000000?style=flat-square&logo=apple&logoColor=white)
![Desktop](https://img.shields.io/badge/Desktop_JVM-007396?style=flat-square&logo=openjdk&logoColor=white)
![Web Wasm](https://img.shields.io/badge/Web_Wasm-654FF0?style=flat-square&logo=webassembly&logoColor=white)

</div>

> [!NOTE]
> **Disclaimer:** ValiantUI Compose is an independent, community-driven port of [HeroUI](https://heroui.com/) (formerly NextUI) for Compose Multiplatform. It is not affiliated with, maintained, sponsored, or endorsed by HeroUI Inc. All design concepts and original trademarks belong to their respective owners.

---

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

## License

This project is licensed under the Apache License, Version 2.0 - see the [LICENSE](LICENSE) file for details.
