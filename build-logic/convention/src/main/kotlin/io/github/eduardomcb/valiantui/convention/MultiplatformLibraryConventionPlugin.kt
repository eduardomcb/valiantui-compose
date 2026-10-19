package io.github.eduardomcb.valiantui.convention

import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class MultiplatformLibraryConventionPlugin : Plugin<Project> {
    @OptIn(ExperimentalWasmDsl::class)
    override fun apply(target: Project) = with(target) {
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

        pluginManager.apply("org.jetbrains.kotlin.multiplatform")
        pluginManager.apply("com.android.kotlin.multiplatform.library")

        extensions.configure<KotlinMultiplatformExtension> {
            jvm {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_11)
                }
            }

            js {
                browser()
            }

            wasmJs {
                browser()
            }

            listOf(
                iosArm64(),
                iosSimulatorArm64()
            ).forEach { iosTarget ->
                iosTarget.binaries.framework {
                    baseName = project.name.replace("-", "").replace(":", "")
                    isStatic = true
                }
            }

            extensions.configure<KotlinMultiplatformAndroidLibraryExtension> {
                val compileSdkVer = libs.findVersion("android-compileSdk").get().requiredVersion.toInt()
                val minSdkVer = libs.findVersion("android-minSdk").get().requiredVersion.toInt()

                compileSdk = compileSdkVer
                minSdk = minSdkVer

                androidResources {
                    enable = true
                }
            }
        }
    }
}
