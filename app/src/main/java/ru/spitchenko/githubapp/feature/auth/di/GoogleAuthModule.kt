package ru.spitchenko.githubapp.feature.auth.di

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.Module
import dagger.Provides
import ru.spitchenko.githubapp.BuildConfig

@Module
class GoogleAuthModule {

    @Provides
    fun provideGoogleSignInClient(context: Context): GoogleSignInClient =
        GoogleSignIn.getClient(
            context,
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(BuildConfig.GOOGLE_AUTH_CLIENT_ID)
                .requestEmail()
                .build()
        )
}