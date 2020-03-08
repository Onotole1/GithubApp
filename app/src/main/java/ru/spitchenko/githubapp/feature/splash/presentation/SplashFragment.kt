package ru.spitchenko.githubapp.feature.splash.presentation

import android.os.Bundle
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SplashFragment: DaggerFragment() {

    @Inject
    lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.navigate()
    }
}