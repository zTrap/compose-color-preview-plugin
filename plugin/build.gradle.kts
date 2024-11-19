import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(deps.plugins.kotlin.forPlugin)
    alias(deps.plugins.intellij)
    java
}

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()

    intellijPlatform.defaultRepositories()
}

group = "ru.ztrap.plugin.idea"
version = "${deps.versions.plugin.get()}-${deps.versions.idea.code.min.get()}"

dependencies {
    intellijPlatform {
        intellijIdeaCommunity(deps.versions.idea.name)
        bundledPlugin("com.intellij.java")
        bundledPlugin("org.jetbrains.kotlin")

        pluginVerifier()
        zipSigner()
        instrumentationTools()
    }
}

intellijPlatform {
    buildSearchableOptions = false

    pluginVerification {
        ides.recommended()
    }

    pluginConfiguration {
        version = project.version.toString()
        ideaVersion {
            sinceBuild = deps.versions.idea.code.min
            untilBuild = "${deps.versions.idea.code.max.get()}.*"
        }
    }

    signing {
        certificateChainFile = file(stringProp("publishing.plugin.key.chain"))
        privateKeyFile = file(stringProp("publishing.plugin.key"))
        password = stringProp("publishing.plugin.password")
    }

    publishing {
        token = stringProp("publishing.plugin.token")
    }
}

val jvmVersion = deps.versions.jvm.get()

tasks {
    compileJava {
        sourceCompatibility = jvmVersion
        targetCompatibility = jvmVersion
    }

    compileKotlin {
        compilerOptions.jvmTarget = JvmTarget.fromTarget(jvmVersion)
    }
}

val runIdeK2 by intellijPlatformTesting.runIde.registering {
    task {
        jvmArgumentProviders += CommandLineArgumentProvider {
            listOf("-Didea.kotlin.plugin.use.k2=true")
        }
    }
}

fun stringProp(key: String) = project.findProperty(key).toString()
