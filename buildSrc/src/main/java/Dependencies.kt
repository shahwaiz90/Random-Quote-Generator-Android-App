/*
 * Copyright (c) 2020 Ahmad Shahwaiz. All rights reserved.
 */

object Versions {

    const val appcompat = "1.1.0"
    const val annotation = "1.1.0"
    const val constraintLayout = "2.0.0-beta6"
    const val dagger = "2.22.1"
    const val ktx = "1.2.0-alpha01"
    const val kotlin = "1.3.41"
    const val rxjava = "2.2.8"
    const val rxAndroidVersion = "2.0.2"
    const val gsonVersion = "2.8.0"
    const val retrofit = "2.5.0"
    const val multiDexVersion = "2.0.1"
    const val loggingInterceptor = "3.12.1"
    const val okHttpVersion = "3.10.0"
    const val lifecycle = "2.0.0"
    const val timber = "4.7.1"
    const val navigation = "2.1.0"
    const val gradleToolsPluginVersion = "3.4.2"

}

object Plugins {
    const val gradle = "com.android.tools.build:gradle:${Versions.gradleToolsPluginVersion}"

    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    const val navigationSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"

}

object Libraries {

    // Kotlin
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val kotlinTest = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"

    const val kotlinAllOpen = "org.jetbrains.kotlin:kotlin-allopen:${Versions.kotlin}" // is this used?
    const val multiDex = "androidx.multidex:multidex:${Versions.multiDexVersion}"

    // Lifecycle
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val lifecycleKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    // Android X
    const val appCompatX = "androidx.appcompat:appcompat:${Versions.appcompat}"

    const val annotationX = "androidx.annotation:annotation:${Versions.annotation}"
    const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    // Rx
    const val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"

    const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val rxjavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofitScalarConverter =
            "com.squareup.retrofit2:converter-scalars:${Versions.retrofit}"
    const val retrofitMock =
            "com.squareup.retrofit2:retrofit-mock:${Versions.retrofit}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    // OkHttp
    const val okHttpCore =
            "com.squareup.okhttp3:okhttp:${Versions.okHttpVersion}"
    const val okHttpUrlConnection =
            "com.squareup.okhttp3:okhttp-urlconnection:${Versions.okHttpVersion}"
    const val loggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    // Dagger
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"

    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val daggerAndroidProcessor =
            "com.google.dagger:dagger-android-" +
                    "processor:${Versions.dagger}"

}
