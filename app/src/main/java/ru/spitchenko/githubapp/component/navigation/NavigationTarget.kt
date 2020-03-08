package ru.spitchenko.githubapp.component.navigation

interface NavigationTarget<in T> {

	fun navigate(source: T)
}