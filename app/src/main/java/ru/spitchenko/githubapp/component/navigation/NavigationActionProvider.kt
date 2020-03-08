package ru.spitchenko.githubapp.component.navigation

import androidx.lifecycle.LifecycleOwner

interface NavigationActionProvider<T> {

	fun bind(source: T, lifecycleOwner: LifecycleOwner)
}