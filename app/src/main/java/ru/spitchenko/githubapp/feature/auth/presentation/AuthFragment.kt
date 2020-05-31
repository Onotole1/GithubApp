package ru.spitchenko.githubapp.feature.auth.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.launch
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.spitchenko.githubapp.R
import ru.spitchenko.githubapp.component.ui.toast
import ru.spitchenko.githubapp.databinding.FragmentAuthBinding

class AuthFragment(
    signInContract: ActivityResultContract<Unit, GoogleSignInResult>,
    private val viewModel: AuthViewModel
) : Fragment() {

    private val signIn = registerForActivityResult(signInContract) { result ->
        when (result) {
            is GoogleSignInResult.Success -> {
                viewModel.login(result.email)

                findNavController().navigate(R.id.action_authFragment_to_github)
            }

            GoogleSignInResult.ApiError -> {
                requireContext().toast(R.string.google_api_error)
            }

            GoogleSignInResult.EmailError -> {
                requireContext().toast(R.string.google_email_error)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAuthBinding.inflate(inflater, container, false)

        binding.signInButton.setOnClickListener {
            signIn.launch()
        }

        return binding.root
    }
}