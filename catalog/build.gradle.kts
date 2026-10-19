plugins {
    id("valiantui.multiplatform.library")
    id("valiantui.compose.library")
}

kotlin {
    android {
        namespace = "io.github.eduardomcb.valiantui.catalog"
    }
    sourceSets {
        commonMain.dependencies {
            implementation(project(":components"))
            implementation(project(":core:theme"))
            implementation(project(":core:interaction"))
        }
    }
}
