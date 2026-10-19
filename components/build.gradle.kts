plugins {
    id("valiantui.multiplatform.library")
    id("valiantui.compose.library")
}

kotlin {
    android {
        namespace = "io.github.eduardomcb.valiantui.components"
    }
    sourceSets {
        commonMain.dependencies {
            api(project(":core:theme"))
            api(project(":core:interaction"))
        }
    }
}
