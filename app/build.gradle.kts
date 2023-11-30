import com.android.build.api.dsl.SigningConfig

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    val name = "com.dondeath.hometraining"
    val debugName = "debug"
    val releaseName = "release"
    val nativeFormat = "-DCMAKE_BUILD_TYPE=%s"
    namespace = name
    compileSdk = libs.versions.android.compile.version.get().toInt()

    defaultConfig {
        applicationId = name
        minSdk = libs.versions.android.min.version.get().toInt()
        targetSdk = libs.versions.android.target.version.get().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true

        externalNativeBuild.cmake.cppFlags("-std=c++17")
    }

    signingConfigs {
        getByName(debugName) {
            storeFile =
                file("../debug.keystore")
            storePassword = "android"
            keyAlias = "androiddebugkey"
            keyPassword = "android"
        }
        create(releaseName) {
            storeFile =
                file("../debug.keystore")
            storePassword = "android"
            keyAlias = "androiddebugkey"
            keyPassword = "android"
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            isDebuggable = true
            signingConfig = signingConfigs.getByName(debugName)
            externalNativeBuild.cmake.arguments(String.format(nativeFormat, debugName))
        }
        release {
            isMinifyEnabled = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro", "../proguard/proguard-rule-log.pro"
            )
            signingConfig = signingConfigs.getByName(releaseName)
            externalNativeBuild.cmake.arguments(String.format(nativeFormat, releaseName))
        }
    }
    // NDK
    externalNativeBuild.cmake {
        path = File("src/main/cpp/CMakeLists.txt")
        version = "3.22.1"
    }
    ndkVersion = "25.1.8937393"
    // NDK

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compiler.extension.kotlin.get()
    }

    // databinding 4.0<
    buildFeatures {
        compose = true
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.multidex)
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.androidx.lifecycle.extensions)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.security)
    implementation(libs.androidx.annotation)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.constraintlayout)
    implementation(libs.androidx.compose.activity)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.webkit)

    // hilt
    implementation(libs.android.hilt)
    kapt(libs.android.hilt.compiler)

    // compose
    val composeBom = platform(libs.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)
    implementation(libs.compose.ui.ui)
    implementation(libs.compose.ui.ui.viewbinding)
    implementation(libs.compose.ui.ui.tooling.preview)
    debugImplementation(libs.compose.ui.ui.tooling)
    debugImplementation(libs.compose.ui.ui.test.junit4)
    androidTestImplementation(libs.compose.ui.ui.test.manifest)
    implementation(libs.compose.material)
    implementation(libs.compose.material.icons.core)
    implementation(libs.compose.material.icons.extended)
    implementation(libs.compose.material3.window.size.cls)
    implementation(libs.compose.material3.material3)
    implementation(libs.compose.runtime.livedata)
    implementation(libs.compose.runtime.rxjava2)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    // todo 확인 해야함.
//    androidTestImplementation(libs.androidx.espresso.core)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}