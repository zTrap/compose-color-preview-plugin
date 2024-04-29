plugins {
    alias(deps.plugins.compose)
    alias(deps.plugins.kotlin.forSample)
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
