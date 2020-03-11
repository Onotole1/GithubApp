package ru.spitchenko.githubapp.component.navigation

import android.app.Activity
import android.os.Bundle
import androidx.navigation.findNavController
import ru.spitchenko.githubapp.R
import ru.spitchenko.githubapp.feature.github.details.presentation.model.RepositoryArgs
import ru.spitchenko.githubapp.feature.github.details.presentation.model.repositoryArgs
import ru.spitchenko.githubapp.feature.github.domain.model.Repository

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

data class GithubToDetails(val repository: Repository) : NavigationTarget<Activity> {

	override fun navigate(source: Activity) {
		source.findNavController(R.id.nav_host_fragment).navigate(R.id.action_githubFragment_to_details, Bundle().apply {
			repositoryArgs = RepositoryArgs(repository)
		})
	}
}

private fun Activity.navigate(actionId: Int) {
    findNavController(R.id.nav_host_fragment).navigate(actionId)
}