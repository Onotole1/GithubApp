object Dependencies {

    object Build {

        const val ANDROID_GRADLE_PLUGIN =
            "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_PLUGIN}"
        const val KOTLIN_GRADLE_PLUGIN =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
        const val GOOGLE_SERVICES = "com.google.gms:google-services:${Versions.GOOGLE_SERVICES}"
        const val SERIALIZATION = "org.jetbrains.kotlin:kotlin-serialization:${Versions.KOTLIN}"
    }

    object Debug {

        const val LEAKCANARY_DEBUG =
            "com.squareup.leakcanary:leakcanary-android:${Versions.LEAKCANARY}"
    }

    object Main {

        object Kotlin {

            const val STANDARD_LIBRARY =
                "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"
            const val SERIALIZATION =
                "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.KOTLINX_SERIALIZATION_RUNTIME}"
        }

        object Androidx {

            const val APPCOMPAT = "androidx.core:core-ktx:${Versions.APPCOMPAT}"
            const val FRAGMENT = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_VERSION}"
            const val CORE = "androidx.core:core-ktx:${Versions.ANDROIDX_CORE}"
            const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
            const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Versions.RECYCLER_VIEW}"
            const val CONSTRAINT_LAYOUT =
                "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
            const val SWIPE_REFRESH_LAYOUT =
                "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.SWIPE_REFRESH_LAYOUT}"
        }

        const val PLAY_SERVICES_AUTH =
            "com.google.android.gms:play-services-auth:${Versions.PLAY_SERVICES_AUTH}"

        object KOIN {

            const val ANDROID = "org.koin:koin-android:${Versions.KOIN}"
            const val VIEW_MODEL = "org.koin:koin-android-viewmodel:${Versions.KOIN}"
        }

        object Room {

            const val RUNTIME = "androidx.room:room-runtime:${Versions.ROOM}"
            const val COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"
            const val COROUTINES = "androidx.room:room-ktx:${Versions.ROOM}"
        }

        object Navigation {

            const val FRAGMENT =
                "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
            const val UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
        }

        object Glide {

            const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
            const val COMPILER = "com.github.bumptech.glide:compiler:${Versions.GLIDE}"
        }

        const val SERIALIZATION_RUNTIME =
            "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.SERIALIZATION_RUNTIME}"

        object OkHttp {

            const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OK_HTTP}"
            const val LOGGING = "com.squareup.okhttp3:logging-interceptor:${Versions.OK_HTTP}"
            const val URLCONNECTION =
                "com.squareup.okhttp3:okhttp-urlconnection:${Versions.OK_HTTP}"
        }

        object Retrofit {

            const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
            const val SERIALIZATION_CONVERTER =
                "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.RETROFIT_SERIALIZATION_CONVERTER}"
        }

        const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"

        object Lifecycle {

            const val EXTENSIONS =
                "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE_EXTENSION}"
            const val COMPILER =
                "androidx.lifecycle:lifecycle-compiler:${Versions.LIFECYCLE_EXTENSION}"
            const val LIVE_DATA_KTX =
                "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_LIVE_DATA_KTX}"
        }

        object Coroutines {

            const val COROUTINES =
                "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES_VERSION}"
            const val COROUTINES_ANDROID =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_VERSION}"
            const val PLAY_SERVICES =
                "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.COROUTINES_PLAY_SERVICES}"
        }
    }

    object Test {

        const val JUNIT = "junit:junit:${Versions.JUNIT}"
        const val ANDROIDX_CORE_TESTING = "androidx.arch.core:core-testing:${Versions.CORE_TESTING}"
        const val KOIN_TESTING = "org.koin:koin-test:${Versions.KOIN}"
        const val KOIN_FRAGMENT = "org.koin:koin-androidx-fragment:${Versions.KOIN}"
        const val SUPPORT_TEST_RUNNER = "androidx.test:runner:${Versions.SUPPORT_TEST_RUNNER}"
        const val SUPPORT_TEST_RULES = "androidx.test:rules:${Versions.SUPPORT_TEST_RULES}"
        const val MOCKITO_KOTLIN =
            "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.MOCKITO_KOTLIN}"
        const val TRUTH = "com.google.truth:truth:${Versions.TRUTH}"
        const val ROOM = "androidx.room:room-testing:${Versions.ROOM}"
    }
}