plugins {
    id(libs.plugins.agp.library.get().pluginId)
    id(libs.plugins.kotlin.kotlin.get().pluginId)
}
android {
    namespace = "kg.geekstudio.kitsutest.core_ui"
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

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
//    kotlinOptions {
//        jvmTarget = options.versions.kotlinJvmTargetOptions.get()
//    }
    buildFeatures {
        viewBinding = true
    }
}
dependencies {
    // Modules
    misc.versions.apply {
        implementation(project(domainProjectPath.get()))
        implementation(project(coreProjectPath.get()))
        implementation(project(dataProjectPath.get()))
    }
    // UI-Component
    implementation(libs.ui.uCrop)
    implementation(libs.ui.activity)
    implementation(libs.ui.swipeToRefresh)
    implementation(libs.ui.glide)
    implementation(libs.ui.material)
    implementation(libs.ui.coil)
    // coroutine
    implementation(libs.coroutines.core)
    // ui
    implementation(libs.ui.multiPicker)
    // lifecycle
    implementation(libs.lifecycle.commonJava8)
    implementation(libs.lifecycle.runtime)
    // paging3
    implementation(libs.paging.runtime)
    implementation(libs.paging.common)
    // navigation
    implementation(libs.navigation.ui)
    implementation(libs.navigation.fragment)
    // squareUp
    implementation(libs.squareup.retrofitConverterGson)
    // koin
    implementation(libs.bundles.koin)
}