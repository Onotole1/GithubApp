package ru.spitchenko.githubapp.component.navigation

interface Navigator<T> {

	fun navigate(target: NavigationTarget<T>)
}