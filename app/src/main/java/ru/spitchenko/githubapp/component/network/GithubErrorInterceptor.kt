package ru.spitchenko.githubapp.component.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class GithubErrorInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(chain.request())
            .apply {
                if (code == 403) {
                    throw TooManyRequestsError()
                }
            }
}