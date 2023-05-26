plugins {
    id(libs.plugins.agp.library.get().pluginId)
    id(libs.plugins.kotlin.kotlin.get().pluginId)
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "kg.geekstudio.kitsutest.main"
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
        sourceCompatibility = JavaVersion.VERSION_16
        targetCompatibility = JavaVersion.VERSION_16
    }
    kotlinOptions {
        jvmTarget = buildOptions.versions.kotlinJvmTargetOptions.get()
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    misc.versions.apply {
        // Modules
        implementation(project(coreProjectPath.get()))
        implementation(project(domainProjectPath.get()))
        implementation(project(dataProjectPath.get()))
        implementation(project(coreuiProjectPath.get()))
    }
    // viewBinding
    implementation(libs.ui.viewBindingPropertyDelegate)
    // navigation
    implementation(libs.navigation.ui)
    implementation(libs.navigation.fragment)
    // koin
    implementation(libs.koin.core)
    implementation(libs.coroutines.android)
    

    implementation(libs.koin.navigation)
    // squareUp
    implementation(libs.squareup.retrofitConverterGson)
    // ui
    implementation(libs.ui.uCrop)
    implementation(libs.ui.imagePicker)
    implementation(libs.ui.glide)
    implementation(libs.ui.circleImgView)
    implementation(libs.ui.shimmer)
    implementation(libs.ui.maskedEditText)
    implementation(libs.ui.flexBoxLayout)
    implementation(libs.ui.stfalconImgViewer)
    implementation(libs.ui.viewBindingPropertyDelegate)
    implementation(libs.ui.dotsIndicator)
    implementation(libs.ui.viewPager2)
    // PekoPermission
    implementation(libs.pekoAsync.pekoAsync)
    implementation(libs.androidx.appCompat)
    // paging3
    implementation(libs.paging.common)
    implementation(libs.paging.runtime)
    // jetbrains
    implementation(libs.jetBrains.kotlin.stdlib)
    // androidx
    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.coreKtx)
    implementation(libs.androidx.legacySupport)
    // ui
    implementation(libs.ui.material)
    implementation(libs.ui.constraint)
    implementation(libs.ui.swipeToRefresh)
    implementation(libs.ui.pinview)
    implementation(libs.ui.recyclerSelection)
    // lifecycle
    implementation(libs.lifecycle.commonJava8)
    implementation(libs.lifecycle.runtime)
    implementation(libs.lifecycle.viewModel)

}