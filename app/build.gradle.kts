plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.attendease"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.attendease"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation ("com.google.zxing:core:3.4.1")
    implementation ("com.journeyapps:zxing-android-embedded:4.2.0")

    implementation ("io.realm:realm-gradle-plugin:10.18.0")
    implementation ("com.squareup.picasso:picasso:2.71828")
    implementation ("com.google.android.gms:play-services-wallet:19.4.0")
    implementation ("com.google.code.gson:gson:2.8.6")
    implementation ("com.google.mlkit:barcode-scanning:16.1.2")
    implementation ("com.journeyapps:zxing-android-embedded:4.3.0")
    implementation ("com.google.zxing:core:3.3.3")
    implementation ("com.google.android.material:material:1.3.0")
    implementation ("androidx.appcompat:appcompat:1.3.0")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}