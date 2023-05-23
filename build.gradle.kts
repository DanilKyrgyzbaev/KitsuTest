plugins {
    alias(libs.plugins.agp.application) apply false
    alias(libs.plugins.agp.library) apply false
    alias(libs.plugins.jetBrains.kotlin.gradle) apply false
    alias(libs.plugins.jetBrains.kotlin.serialization) apply false
    alias(libs.plugins.jetBrains.dokka)
    alias(libs.plugins.navSafeArgs) apply false
    alias(libs.plugins.ktlint.gradle) apply false
    alias(libs.plugins.com.android.test) apply false
}
repositories {
    google()
}

buildscript {
    dependencies {
        classpath(libs.googlePlayService.googlePlayService)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}