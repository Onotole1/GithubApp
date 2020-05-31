package ru.spitchenko.githubapp.component.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import ru.spitchenko.githubapp.BuildConfig
import ru.spitchenko.githubapp.component.log.info
import ru.spitchenko.githubapp.component.network.GithubErrorInterceptor

@Suppress("EXPERIMENTAL_API_USAGE")
val networkModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(GithubErrorInterceptor)
            .applyLoggingForDebug()
            .build()
    }

    single {
        val okHttpClient = get<OkHttpClient>()

        Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_API_URL)
            .addConverterFactory(Json {
                ignoreUnknownKeys = true
                isLenient = true
            }.asConverterFactory("application/json".toMediaType()))
            .client(okHttpClient)
            .build()
    }
}

private fun OkHttpClient.Builder.applyLoggingForDebug(): OkHttpClient.Builder =
    if (BuildConfig.DEBUG) {
        addNetworkInterceptor(getHttpLoggingInterceptor())
    } else {
        this
    }

private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor(getLoggingInterceptorLogger())
        .apply { level = HttpLoggingInterceptor.Level.BODY }

private fun getLoggingInterceptorLogger() = object : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        info(message)
    }
}