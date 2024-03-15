plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

group = "com.bizyback.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.android.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("hilt-convention") {
            id = "bizyback.convention.hilt"
            implementationClass = "HiltConventionPlugin"
        }
        register("application-convention") {
            id = "bizyback.convention.application"
            implementationClass = "ApplicationConventionPlugin"
        }
        register("library-convention") {
            id = "bizyback.convention.library"
            implementationClass = "LibraryConventionPlugin"
        }
        register("compose-application-convention") {
            id = "bizyback.convention.compose.application"
            implementationClass = "ComposeApplicationConventionPlugin"
        }
        register("compose-library-convention") {
            id = "bizyback.convention.compose.library"
            implementationClass = "ComposeLibraryConventionPlugin"
        }
        register("module-convention") {
            id = "bizyback.convention.module"
            implementationClass = "ModuleConventionPlugin"
        }
        register("feature-convention") {
            id = "bizyback.convention.feature"
            implementationClass = "FeatureConventionPlugin"
        }
    }
}