import com.android.build.api.dsl.ApplicationExtension
import extensions.androidTestImplementation
import extensions.api
import extensions.getBundle
import extensions.getLibrary
import extensions.implementation
import extensions.testImplementation
import helpers.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

/**
 * PROJECT : Template
 * AUTHOR  : mambo
 * EMAIL   : mambobryan@gmail.com
 * DATE    : Wed 07 February 2024
 * TIME    : 1:00 pm
 */

class ApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = AndroidSdk.targetSdk
            }
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                // modules
                implementation(project(AndroidModules.Ui.presentation))
                implementation(project(AndroidModules.Ui.common))
                implementation(project(AndroidModules.Data.data))

                // work manager
                implementation(libs.getLibrary("androidx-hilt-work"))
                implementation(libs.getLibrary("androidx-work-runtime"))
                implementation(libs.getLibrary("androidx-work-testing"))
            }
        }
    }
}