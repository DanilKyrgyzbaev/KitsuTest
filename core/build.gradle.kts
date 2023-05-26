plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.coroutines.core)
    //Retrofit
    implementation(libs.squareup.retrofit)
    implementation(libs.squareup.retrofitConverterGson)
    implementation(libs.squareup.okHttp)
    implementation(libs.squareup.converterMoshi)
    implementation(libs.squareup.loggingInterceptor)
    implementation(libs.squareup.moshiKotlin)
}