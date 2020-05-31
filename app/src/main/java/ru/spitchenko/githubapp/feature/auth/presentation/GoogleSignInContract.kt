package ru.spitchenko.githubapp.feature.auth.presentation

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException

class GoogleSignInContract(
    private val googleSignInClient: GoogleSignInClient
) : ActivityResultContract<Unit, GoogleSignInResult>() {

    override fun createIntent(context: Context, input: Unit?): Intent =
        googleSignInClient.signInIntent

    override fun parseResult(resultCode: Int, intent: Intent?): GoogleSignInResult {
        val task = GoogleSignIn.getSignedInAccountFromIntent(intent)
        try {
            val email = task.getResult(ApiException::class.java)?.email ?: run {
                return GoogleSignInResult.EmailError
            }

            return GoogleSignInResult.Success(email)
        } catch (e: ApiException) {
            return GoogleSignInResult.ApiError
        }
    }
}