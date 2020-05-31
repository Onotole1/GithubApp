package ru.spitchenko.githubapp.feature.auth.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import org.koin.android.ext.android.inject
import ru.spitchenko.githubapp.R
import ru.spitchenko.githubapp.component.ui.toast
import ru.spitchenko.githubapp.databinding.FragmentAuthBinding

class AuthFragment : Fragment() {

    companion object {
        private const val REQUEST_CODE_SIGN_IN = 7832
    }

    private val googleSignInClient: GoogleSignInClient by inject()

    private val viewModel: AuthViewModel by inject()

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

        // TODO use new activity for result API
        startActivityForResult(signInIntent, REQUEST_CODE_SIGN_IN)
    }

    // TODO use new activity for result API
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

                findNavController().navigate(R.id.action_authFragment_to_github)
            } catch (e: ApiException) {
                requireContext().toast(R.string.google_api_error)
            }
        }
    }
}