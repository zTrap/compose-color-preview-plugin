plugins {
    alias(deps.plugins.kotlin.forSample)
    alias(deps.plugins.compose.compiler)
    alias(deps.plugins.compose)
}

kotlin {
    jvm()

    sourceSets.commonMain {
        dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
        }
    }
}

repositories {
    mavenCentral()
    google()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}
