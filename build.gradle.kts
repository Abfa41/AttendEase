// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Add your classpath dependencies here
        classpath("com.android.tools.build:gradle:4.1.1")

        classpath("io.realm:realm-gradle-plugin:10.18.0") // Replace with the latest version
    }
}

allprojects {
    repositories {
//        google()
//        mavenCentral()
    }
}