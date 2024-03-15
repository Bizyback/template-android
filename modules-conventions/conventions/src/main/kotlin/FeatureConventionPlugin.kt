import com.android.build.gradle.LibraryExtension
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

/**
 * PROJECT : Template
 * AUTHOR  : mambo
 * EMAIL   : mambobryan@gmail.com
 * DATE    : Wed 07 February 2024
 * TIME    : 1:00 pm
 */

class FeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(AndroidConvention.library)
                apply(AndroidConvention.hilt)
                apply(AndroidConvention.Compose.library)
            }
            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = AndroidSdk.targetSdk
            }
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            configurations.configureEach {
                resolutionStrategy {
                    force(libs.findLibrary("junit").get())
                    // Temporary workaround for https://issuetracker.google.com/174733673
                    force("org.objenesis:objenesis:2.6")
                }
            }
            dependencies {
                // modules
                implementation(project(AndroidModules.Ui.common))
                implementation(project(AndroidModules.Data.domain))
                // coroutines
                implementation(libs.getLibrary("kotlinx-coroutines"))
                testImplementation(libs.getLibrary("kotlinx-coroutines-test"))
                // voyager
                implementation(libs.getBundle("voyager"))
                // saket
                implementation(libs.getBundle("saket"))
            }
        }
    }
}