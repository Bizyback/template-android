plugins {
    id("bizyback.convention.library")
    id("bizyback.convention.compose.library")
}

android {
    namespace = "com.bizyback.lib.common"
}

dependencies {

    // <editor-fold desc="modules">
    api(projects.modulesUi.resources)
    api(projects.modulesUi.design)
    // </editor-fold>

    // <editor-fold desc="libraries">
    implementation(libs.bundles.voyager)
    // </editor-fold>

}