plugins {
    id("valiantui.multiplatform.library")
    id("valiantui.compose.library")
}

kotlin {
    android {
        namespace = "io.github.eduardomcb.valiantui.interaction"
    }
    sourceSets {
        commonMain.dependencies {
            implementation(project(":core:theme"))
        }
    }
}
