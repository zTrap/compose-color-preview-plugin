plugins {
    alias(deps.plugins.kotlin.forPlugin)
    alias(deps.plugins.intellij)
    java
}

val eap = false

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()

    intellijPlatform.defaultRepositories()

    if (eap) {
        intellijPlatform.snapshots()
        intellijPlatform.nightly()
    }
}

val suffix = "-EAP".takeIf { eap }.orEmpty()

group = "ru.ztrap.plugin.idea"
version = "${deps.versions.plugin.get()}-${deps.versions.idea.code.min.get()}$suffix"

dependencies {
    intellijPlatform {
        val versionName = if (eap) {
            buildString {
                append(deps.versions.idea.code.min.get())
                append("-EAP-SNAPSHOT")
            }
        } else {
            deps.versions.idea.name.get()
        }
        intellijIdea(versionName) {
            useInstaller = !eap
        }
        bundledPlugin("com.intellij.java")
        bundledPlugin("org.jetbrains.kotlin")

        pluginVerifier()
        zipSigner()
        jetbrainsRuntime()
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
        if (eap) {
            channels = listOf("eap")
        }
    }
}

fun stringProp(key: String) = project.findProperty(key).toString()
