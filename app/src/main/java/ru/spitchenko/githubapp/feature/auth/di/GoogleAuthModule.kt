package ru.spitchenko.githubapp.feature.auth.di

import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.spitchenko.githubapp.BuildConfig

val googleAuthModule = module {
    factory<GoogleSignInClient> {
        GoogleSignIn.getClient(
            androidContext(),
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(BuildConfig.GOOGLE_AUTH_CLIENT_ID)
                .requestEmail()
                .build()
        )
    }
}