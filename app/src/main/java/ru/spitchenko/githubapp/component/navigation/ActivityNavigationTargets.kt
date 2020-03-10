package ru.spitchenko.githubapp.component.navigation

import android.app.Activity
import androidx.navigation.findNavController
import ru.spitchenko.githubapp.R

object Logout : NavigationTarget<Activity> {

	override fun navigate(source: Activity) {
		source.navigate(R.id.action_logout)
	}
}

object SplashToAuth : NavigationTarget<Activity> {

	override fun navigate(source: Activity) {
		source.navigate(R.id.action_splashFragment_to_auth)
	}
}

object SplashToGithub : NavigationTarget<Activity> {

	override fun navigate(source: Activity) {
		source.navigate(R.id.action_splashFragment_to_github)
	}
}

object AuthToGithub : NavigationTarget<Activity> {

	override fun navigate(source: Activity) {
		source.navigate(R.id.action_authFragment_to_github)
	}
}

private fun Activity.navigate(actionId: Int) {
	findNavController(R.id.nav_host_fragment).navigate(actionId)
}