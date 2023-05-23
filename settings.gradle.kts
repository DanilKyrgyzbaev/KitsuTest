pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        maven("bla-bla")
        maven { url = uri("https://jitpack.io") }
    }
    versionCatalogs {
        create("config") {
            from(files("gradle/config.versions.toml"))
        }
        create("misc") {
            from(files("gradle/misc.versions.toml"))
        }
        create("buildOptions") {
            from(files("gradle/options.versions.toml"))
        }
    }
}


rootProject.name = "KitsuTest"
include (":app")
include (":core")
include (":core-ui")
include (":data")
include (":domain")
include(":features:main")
