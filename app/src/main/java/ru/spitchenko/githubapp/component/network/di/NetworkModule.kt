package ru.spitchenko.githubapp.component.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import ru.spitchenko.githubapp.BuildConfig
import ru.spitchenko.githubapp.component.di.ApplicationScope
import ru.spitchenko.githubapp.component.log.info
import ru.spitchenko.githubapp.component.network.GithubErrorInterceptor

@Module
class NetworkModule {

    @UnstableDefault
    @ApplicationScope
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.SERVER_API_URL)
        .addConverterFactory(Json {
            ignoreUnknownKeys = true
            isLenient = true
        }.asConverterFactory("application/json".toMediaType()))
        .client(okHttpClient)
        .build()

    @Provides
    @ApplicationScope
    fun provideOkHttpClient(
        githubErrorInterceptor: GithubErrorInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(githubErrorInterceptor)
        .applyLoggingForDebug()
        .build()

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
}