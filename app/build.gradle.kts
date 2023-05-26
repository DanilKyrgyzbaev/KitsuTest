plugins {
    id(libs.plugins.jetBrains.kotlin.android.get().pluginId)
    id(libs.plugins.agp.application.get().pluginId)
    id(libs.plugins.kotlin.kapt.get().pluginId)
    id(libs.plugins.jetBrains.dokka.get().pluginId)
}

android {
    namespace = misc.versions.appNamespace.get()
    compileSdk = 33

    defaultConfig {
        applicationId = config.versions.applicationId.get()
        minSdk = config.versions.minSdk.get().toInt()
        targetSdk = config.versions.targetSdkVersion.get().toInt()
        versionCode = config.versions.versionCode.get().toInt()
        versionName = config.versions.versionName.get()

        testInstrumentationRunner = config.versions.testInstrumentationRunner.get()
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
        freeCompilerArgs = freeCompilerArgs + "-opt-in=kotlin.RequiresOptIn"
    }
    viewBinding.isEnabled = true

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    misc.versions.apply {
        // Modules
        implementation(project(dataProjectPath.get()))
        implementation(project(domainProjectPath.get()))
        implementation(project(coreProjectPath.get()))
        implementation(project(coreuiProjectPath.get()))
        implementation(project(featureMainProjectPath.get()))

    }

    // koin
    implementation(libs.bundles.koin)
    // coroutine
    implementation(libs.coroutines.android)

    implementation(libs.androidx.legacySupport)
    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.coreKtx)
    implementation(libs.jetBrains.kotlin.stdlib)
    // ui
    implementation(libs.ui.material)
    implementation(libs.ui.constraint)
    implementation(libs.ui.recyclerSelection)

}
