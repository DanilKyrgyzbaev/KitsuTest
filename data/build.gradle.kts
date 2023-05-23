plugins {
    id(libs.plugins.agp.library.get().pluginId)
    id(libs.plugins.kotlin.kotlin.get().pluginId)
}
android {
    namespace = "kg.geekstudio.kitsutest.data"
    compileSdk = config.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = config.versions.minSdk.get().toInt()
        targetSdk = config.versions.compileSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName(config.versions.releaseBuildType.get()) {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }

        getByName(config.versions.debugBuildType.get()) {
            buildConfigField("String", "BASE_URL", "\"https://rickandmortyapi.com/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = buildOptions.versions.kotlinJvmTargetOptions.get()
    }

    buildFeatures {
        viewBinding = true
    }
}
dependencies {
    misc.versions.apply {
        implementation(project(domainProjectPath.get()))
        implementation(project(coreProjectPath.get()))
    }

    // coroutine
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

    // koin
    implementation(libs.koin.core)

}