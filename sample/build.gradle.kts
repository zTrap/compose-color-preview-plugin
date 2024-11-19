plugins {
    alias(deps.plugins.kotlin.forSample)
    alias(deps.plugins.compose.compiler)
    alias(deps.plugins.compose)
}

kotlin {
    jvm()

    sourceSets.commonMain {
        dependencies {
            implementation(deps.compose.runtime)
            implementation(deps.compose.foundation)
            implementation(deps.compose.material)
            implementation(deps.compose.ui)
            implementation(deps.compose.resources)
            implementation(deps.compose.preview)
        }
    }
}

repositories {
    mavenCentral()
    google()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}
