plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
//    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.zaar.chequeinfo"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.zaar.chequeinfo"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
//    testOptions.unitTests.all { it.useJUnitPlatform() }
    testOptions {
        unitTests.all { it.useJUnitPlatform() }
        packaging {
            resources.excludes.add("META-INF/*")
        }
    }
}

dependencies {
    //android common libs
    implementation(libs.bundles.android.common.libs.impl)
    implementation(libs.bundles.android.addLibs.impl)
    implementation(libs.bundles.kotlinx.serialization.impl)
    implementation(libs.androidx.media3.common.ktx)

    //testing
    debugImplementation(libs.androidx.test.coreKtx)
    debugImplementation(libs.androidx.fragment.testing)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.junit.jupiter.v581)
    androidTestImplementation(libs.junit.jupiter.v591)
    testImplementation(libs.junit)
    testImplementation(libs.junit.jupiter.v581)
    testImplementation(libs.junit.jupiter.v591)

    //espresso
    androidTestImplementation(libs.bundles.espresso.atimpl)
    implementation(libs.bundles.espresso.impl)
    debugImplementation(libs.androidx.test.monitor)

    //mockito
    implementation(libs.mockito.core)

    //impl liveData and viewModel
    implementation(libs.androidx.lifecycle.extensions)

    //impl room
    implementation(libs.bundles.room)
    ksp(libs.androidx.room.compiler)
//    kapt(libs.androidx.room.compiler)

    //navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    //+Feature module Support
    implementation(libs.androidx.navigation.dynamic.features.fragment)
    //+Testing Navigation
    androidTestImplementation(libs.androidx.navigation.testing)

    //retrofit
    implementation(libs.bundles.retrofit)

    //coroutines
    implementation(libs.bundles.coroutines.common.impl)
    //+coroutines libs
    implementation(libs.bundles.coroutines.addLibs.impl)

    //rx.java
    implementation(libs.bundles.rxJava.impl)

    //dagger2
    implementation(libs.dagger2)
    ksp(libs.dagger2.compiler)
}