pluginManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    versionCatalogs.create("deps") {
        from(files("gradle/deps.versions.toml"))
    }
}

rootProject.name = "compose-color-preview"

include(
    ":plugin",
    ":sample",
)

project(":plugin").name = "compose-color-preview-plugin"