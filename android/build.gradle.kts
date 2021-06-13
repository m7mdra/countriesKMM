val kotlin_version: String by extra
plugins {
    id("com.android.application")
    kotlin("android")
}
apply {
    plugin("kotlin-android")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")
    implementation ("com.github.corouteam:GlideToVectorYou:v2.0.0")
    implementation("androidx.core:core-ktx:1.5.0")
    implementation ("com.squareup.picasso:picasso:2.71828")

}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.m7mdra.myapplication.android"
        minSdkVersion(24)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}
repositories {
    mavenCentral()
}