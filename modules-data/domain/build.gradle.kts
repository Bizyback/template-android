@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("bizyback.convention.module")
}

android {
    namespace = "com.bizyback.lib.domain"
}

dependencies {

    // modules
    implementation(projects.modulesUi.resources)

}