plugins {
    id("bizyback.convention.library")
    id("bizyback.convention.compose.library")
}

android {
    namespace = "com.bizyback.lib.design"
}

dependencies {

    /**
     * MODULES
     */
    implementation(projects.modulesUi.resources)

    /**
     * LIBRARIES
     */

    // splash screen
    implementation(libs.androidx.core.splashscreen)

}