plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(project(misc.versions.coreProjectPath.get()))
    // coroutine
    implementation(libs.coroutines.core)
    // koin
    implementation(libs.koin.core)
    // paging3
//    implementation(libs.paging.common)
}