package extensions

import com.android.build.api.dsl.CommonExtension
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

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *>,
) {

    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    commonExtension.apply {

        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = libs.getVersion("kotlin-compose-compiler")
        }

        kotlinOptions {
            freeCompilerArgs = freeCompilerArgs
        }

        dependencies {
            // compose
            val bom = libs.findLibrary("compose-bom").get()
            implementation(platform(bom))
            implementation(libs.getBundle("compose"))
            androidTestImplementation(platform(bom))
            debugImplementation(libs.getLibrary("compose-ui-tooling"))
            debugImplementation(libs.getLibrary("compose-ui-test-manifest"))
            androidTestImplementation(libs.getLibrary("compose-ui-test-junit4"))
        }
    }
}