import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

/**
 * PROJECT : Template
 * AUTHOR  : mambo
 * EMAIL   : mambobryan@gmail.com
 * DATE    : Wed 07 February 2024
 * TIME    : 1:00 pm
 */

class HiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target){

            with(pluginManager) {
                apply("com.google.dagger.hilt.android")
                apply("com.google.devtools.ksp")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
                add("implementation", libs.findBundle("hilt").get())
                add("ksp", libs.findLibrary("androidx-hilt-compiler").get())
                add("ksp", libs.findLibrary("dagger-hilt-compiler").get())
            }
        }
    }
}