# ValiantUI Compose Documentation & Showcase

Bem-vindo a documentacao do **ValiantUI Compose**, implementacao do design system em Kotlin Multiplatform (Compose Multiplatform).

## Estrutura do Projeto

```text
├── build-logic/convention      # Plugins Gradle reutilizaveis
├── core/
│   ├── theme/                  # ValiantTheme: ValiantColors, ValiantTypography, ValiantShapes, ValiantSpacing, ValiantRadius
│   └── interaction/            # Feedback tatil, press-scaling (0.97f), hover, cursor
├── components/                 # Modulo central de componentes
│   ├── button/                 # Button, ButtonGroup
│   ├── feedback/               # Spinner
│   ├── input/                  # Input
│   ├── card/                   # Card
│   └── overlay/                # Overlay
├── catalog/                    # App Compose Multiplatform com catalogo visual dos componentes
└── docs/                       # Documentacao tecnica
```

## Como Rodar o Catalogo Visual

- **Desktop (JVM)**: `./gradlew :desktopApp:run`
- **WebAssembly (Wasm)**: `./gradlew :webApp:wasmJsBrowserDevelopmentRun`
- **Android**: `./gradlew :androidApp:assembleDebug`
