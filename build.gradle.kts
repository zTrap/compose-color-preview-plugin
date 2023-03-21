fun prop(key: String) = project.findProperty(key).toString()

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.8.10"
    id("org.jetbrains.intellij") version "1.13.2"
}

group = "ru.ztrap.plugin.idea"
version = "0.0.1"

repositories {
    mavenCentral()
}

intellij {
    version.set("2022.3.3")
    type.set("IC")

    plugins.set(
        listOf(
            "org.jetbrains.kotlin",
            "com.intellij.java"
        ),
    )
}

tasks {
    buildSearchableOptions {
        enabled = false
    }

    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = JavaVersion.VERSION_17.toString()
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
    }

    patchPluginXml {
        version.set(project.version.toString())
        sinceBuild.set("221")
        untilBuild.set("233.*")
    }

    signPlugin {
        certificateChainFile.set(file(prop("publishing.plugin.key.chain")))
        privateKeyFile.set(file(prop("publishing.plugin.key")))
        password.set(prop("publishing.plugin.password"))
    }

    publishPlugin {
        token.set(prop("publishing.plugin.token"))
    }
}
