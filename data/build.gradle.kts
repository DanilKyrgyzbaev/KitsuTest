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
    misc.versions.apply {
        implementation(project(domainProjectPath.get()))
        implementation(project(coreProjectPath.get()))
    }

    //Retrofit
    implementation(libs.squareup.retrofit)
    implementation(libs.squareup.retrofitConverterGson)
    implementation(libs.squareup.okHttp)
    implementation(libs.squareup.converterMoshi)
    implementation(libs.squareup.loggingInterceptor)
    implementation(libs.squareup.moshiKotlin)

    // coroutine
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

    // koin
    implementation(libs.koin.core)

}