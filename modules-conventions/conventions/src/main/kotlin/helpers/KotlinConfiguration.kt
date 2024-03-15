package helpers

import AndroidSdk
import com.android.build.api.dsl.CommonExtension
import extensions.kotlinOptions
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.provideDelegate

/**
 * PROJECT : Template
 * AUTHOR  : mambo
 * EMAIL   : mambobryan@gmail.com
 * DATE    : Wed 07 February 2024
 * TIME    : 1:00 pm
 */

internal fun Project.configureKotlinAndroid(
    extension: CommonExtension<*, *, *, *, *>,
) {
    extension.apply {
        compileSdk = AndroidSdk.compileSdk
        defaultConfig {
            minSdk = AndroidSdk.minimumSdk
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
        buildFeatures {
            buildConfig = true
        }
        kotlinOptions {
            val warningsAsErrors: String? by project
            allWarningsAsErrors = warningsAsErrors.toBoolean()
            freeCompilerArgs = freeCompilerArgs + listOf(
                "-opt-in=kotlin.RequiresOptIn",
                "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                "-opt-in=kotlinx.coroutines.FlowPreview",
                "-opt-in=kotlin.Experimental",
            )
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }
}