# Installation & Setup

Learn how to explore, run, and eventually integrate **ValiantUI Compose** into your Kotlin Multiplatform projects.

---

!!! warning "Under Active Development"
    **ValiantUI Compose is currently in early development and has not been published to Maven Central or any package repository yet.**
    
    You cannot install it as an external dependency in your applications at this time, and it is not ready for production use. You can, however, clone the repository to test components locally, contribute to development, or run the interactive catalog.

---

## Running the Project Locally

The best way to evaluate ValiantUI Compose today is to clone the repository and run the multiplatform catalog application.

### 1. Clone the Repository

```bash
git clone https://github.com/eduardomcb/valiantui-compose.git
cd valiantui-compose
```

### 2. Run the Multiplatform Catalog

The project includes an interactive catalog (`:catalog`) that runs across multiple targets:

=== "Desktop (JVM)"

    ```bash
    ./gradlew :desktopApp:run
    ```

=== "Web (WebAssembly)"

    ```bash
    ./gradlew :webApp:wasmJsBrowserDevelopmentRun
    ```

=== "Android"

    ```bash
    ./gradlew :androidApp:assembleDebug
    ```

### 3. Run Automated Tests

To run the Compose UI and unit test suite:

```bash
./gradlew :components:jvmTest
```

---

## Planned Dependency Setup (Preview)

Once the first stable or milestone release is published to Maven Central, integration will follow the standard Gradle setup below:

=== "Gradle (Kotlin DSL)"

    In your `settings.gradle.kts`:

    ```kotlin
    dependencyResolutionManagement {
        repositories {
            google()
            mavenCentral()
        }
    }
    ```

    In your shared module `build.gradle.kts`:

    ```kotlin
    kotlin {
        sourceSets {
            commonMain.dependencies {
                implementation("io.github.eduardomcb:valiantui-core-theme:<version>")
                implementation("io.github.eduardomcb:valiantui-core-interaction:<version>")
                implementation("io.github.eduardomcb:valiantui-components:<version>")
            }
        }
    }
    ```

=== "Version Catalog (libs.versions.toml)"

    ```toml
    [versions]
    valiantui = "0.1.0"

    [libraries]
    valiantui-theme = { module = "io.github.eduardomcb:valiantui-core-theme", version.ref = "valiantui" }
    valiantui-interaction = { module = "io.github.eduardomcb:valiantui-core-interaction", version.ref = "valiantui" }
    valiantui-components = { module = "io.github.eduardomcb:valiantui-components", version.ref = "valiantui" }
    ```

---

## Theme Setup

Wrap your application root in `ValiantTheme`:

```kotlin
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import io.github.eduardomcb.valiantui.components.button.Button
import io.github.eduardomcb.valiantui.components.button.ButtonVariant
import io.github.eduardomcb.valiantui.theme.ValiantColorRole
import io.github.eduardomcb.valiantui.theme.ValiantTheme

@Composable
fun App() {
    ValiantTheme {
        Button(
            onClick = { println("Clicked") },
            variant = ButtonVariant.Primary,
            color = ValiantColorRole.Primary
        ) {
            Text("Get Started")
        }
    }
}
```
