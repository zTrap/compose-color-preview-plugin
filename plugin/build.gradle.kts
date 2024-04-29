plugins {
    java
    alias(deps.plugins.intellij)
    alias(deps.plugins.kotlin.forPlugin)
}

group = "ru.ztrap.plugin.idea"
version = "${deps.versions.plugin.get()}-${deps.versions.idea.code.min.get()}"

// See https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version = deps.versions.idea.name
    type = "IC"

    plugins = listOf(
        "com.intellij.java",
        "org.jetbrains.kotlin",
    )
}

val jvmVersion = deps.versions.jvm.get()

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
        sinceBuild = deps.versions.idea.code.min
        untilBuild = "${deps.versions.idea.code.max.get()}.*"
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

fun prop(key: String) = project.findProperty(key).toString()

repositories {
    mavenCentral()
}
