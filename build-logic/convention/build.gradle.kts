plugins {
    `kotlin-dsl`
}

group = "io.github.eduardomcb.valiantui.buildlogic"

val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

dependencies {
    compileOnly("org.jetbrains.kotlin.multiplatform:org.jetbrains.kotlin.multiplatform.gradle.plugin:${libs.findVersion("kotlin").get().requiredVersion}")
    compileOnly("org.jetbrains.compose:compose-gradle-plugin:${libs.findVersion("composeMultiplatform").get().requiredVersion}")
    compileOnly("org.jetbrains.kotlin:compose-compiler-gradle-plugin:${libs.findVersion("kotlin").get().requiredVersion}")
    compileOnly("com.android.kotlin.multiplatform.library:com.android.kotlin.multiplatform.library.gradle.plugin:${libs.findVersion("agp").get().requiredVersion}")
}

gradlePlugin {
    plugins {
        register("multiplatformLibrary") {
            id = "valiantui.multiplatform.library"
            implementationClass = "io.github.eduardomcb.valiantui.convention.MultiplatformLibraryConventionPlugin"
        }
        register("composeLibrary") {
            id = "valiantui.compose.library"
            implementationClass = "io.github.eduardomcb.valiantui.convention.ComposeLibraryConventionPlugin"
        }
    }
}
