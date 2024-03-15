@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("bizyback.convention.module")
}

android {
    namespace = "com.bizyback.lib.data"
}

dependencies {

    // modules
    implementation(projects.modulesSources.remote)
    implementation(projects.modulesSources.local)
    implementation(projects.modulesData.domain)

}