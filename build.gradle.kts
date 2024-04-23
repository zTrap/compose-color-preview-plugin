fun prop(key: String) = project.findProperty(key).toString()

plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.17.3"
    // https://plugins.jetbrains.com/docs/intellij/using-kotlin.html#kotlin-standard-library
    id("org.jetbrains.kotlin.jvm") version "1.7.0"
}

val ideMinVersion = "223"
val pluginMajorVersion = "0.0.7"

group = "ru.ztrap.plugin.idea"
version = "$pluginMajorVersion-$ideMinVersion"

repositories {
    mavenCentral()
}

// See https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version = "2022.3"
    type = "IC"

    plugins = listOf(
        "com.intellij.java",
        "org.jetbrains.kotlin",
    )
}

val jvmVersion = JavaVersion.VERSION_17.toString()

tasks {
    buildSearchableOptions {
        enabled = false
    }

    // Set the JVM compatibility versions
    compileJava {
        sourceCompatibility = jvmVersion
        targetCompatibility = jvmVersion
    }

    compileKotlin {
        kotlinOptions.jvmTarget = jvmVersion
    }

    patchPluginXml {
        version = project.version.toString()
        sinceBuild = ideMinVersion
        untilBuild = "223.*"
    }

    signPlugin {
        certificateChainFile = file(prop("publishing.plugin.key.chain"))
        privateKeyFile = file(prop("publishing.plugin.key"))
        password = prop("publishing.plugin.password")
    }

    publishPlugin {
        token = prop("publishing.plugin.token")
    }
}
