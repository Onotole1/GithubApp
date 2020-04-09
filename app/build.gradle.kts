plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
    id("kotlinx-serialization")
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
        buildConfigField(
            "String",
            "GOOGLE_AUTH_CLIENT_ID",
            "\"975494690815-dbe8r98dudvgstr3phlbmf090381qqu7.apps.googleusercontent.com\""
        )
        buildConfigField(
            "String",
            "SERVER_API_URL",
            "\"https://api.github.com\""
        )

        kapt {
            arguments {
                arg("room.schemaLocation", "$projectDir/schemas")
                arg("room.incremental", "true")
            }
        }
    }

    signingConfigs {
        getByName("debug") {
            storeFile = rootProject.file("signing/keystore.jks")
            storePassword = "Qwerty1234"
            keyAlias = "test"
            keyPassword = "Qwerty1234"
        }
    }

    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("debug")
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    dataBinding {
        isEnabled = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
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
    playServicesAuth()
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