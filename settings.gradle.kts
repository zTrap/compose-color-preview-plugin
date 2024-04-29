pluginManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

dependencyResolutionManagement {
    versionCatalogs.create("deps") {
        from(files("gradle/deps.versions.toml"))
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "compose-color-preview"

include(
    ":plugin",
    ":sample",
)

project(":plugin").name = "compose-color-preview-plugin"