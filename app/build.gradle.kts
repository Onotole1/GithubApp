plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Versions.MAX_API)
    buildToolsVersion = Versions.BUILD_TOOLS_VERSION
    defaultConfig {
        applicationId = "ru.spitchenko.githubapp"
        minSdkVersion(Versions.MIN_API)
        targetSdkVersion(Versions.MAX_API)
        versionCode = Versions.VERSION_CODE
        versionName = Versions.VERSION_NAME
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    viewBinding {
        isEnabled = true
    }
}

dependencies {
    kotlin()
    kotlinSerializationRuntime()
    coroutines()
    appcompat()
    recyclerView()
    material()
    swipeRefreshLayout()
    room()
    lifecycle()
    glide()
    androidxCore()
    dagger()
    navigation()
    retrofit()
    okhttp()
    constraintLayout()
    timber()
    testing()
    androidTesting()
    leakCanary()
}