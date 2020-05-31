package ru.spitchenko.githubapp.feature.splash.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.koin.android.ext.android.inject
import ru.spitchenko.githubapp.R

class SplashFragment(private val viewModel: SplashViewModel) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when (viewModel.navigate()) {
            SplashNavigation.ToLogin -> findNavController().navigate(R.id.action_splashFragment_to_auth)
            SplashNavigation.ToGithub -> findNavController().navigate(R.id.action_splashFragment_to_github)
        }
    }
}