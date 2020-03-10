package ru.spitchenko.githubapp.component.lifecycle

import androidx.lifecycle.ViewModel
import javax.inject.Provider

typealias ViewModelProviders = Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>