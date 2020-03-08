package ru.spitchenko.githubapp.feature.auth.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import dagger.android.support.DaggerFragment
import ru.spitchenko.githubapp.R
import ru.spitchenko.githubapp.component.ui.toast
import ru.spitchenko.githubapp.databinding.FragmentAuthBinding
import javax.inject.Inject

class AuthFragment : DaggerFragment() {

    companion object {
        private const val REQUEST_CODE_SIGN_IN = 7832
    }

    @Inject
    lateinit var googleSignInClient: GoogleSignInClient

    @Inject
    lateinit var viewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAuthBinding.inflate(inflater, container, false)

        binding.signInButton.setOnClickListener {
            signIn()
        }

        return binding.root
    }

    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, REQUEST_CODE_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val email = task.getResult(ApiException::class.java)?.email ?: run {
                    requireContext().toast(R.string.google_email_error)
                    return
                }

                viewModel.login(email)
            } catch (e: ApiException) {
                requireContext().toast(R.string.google_api_error)
            }
        }
    }
}