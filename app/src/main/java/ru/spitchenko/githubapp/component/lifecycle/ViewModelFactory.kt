package ru.spitchenko.githubapp.component.lifecycle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val providers: ViewModelProviders
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = providers[modelClass]
            ?: throw IllegalArgumentException("unknown model class $modelClass")

        return creator.get() as T
    }
}