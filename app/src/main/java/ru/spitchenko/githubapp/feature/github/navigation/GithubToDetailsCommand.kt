package ru.spitchenko.githubapp.feature.github.navigation

import android.app.Activity
import ru.spitchenko.githubapp.component.navigation.GithubToDetails
import ru.spitchenko.githubapp.component.navigation.Navigator
import ru.spitchenko.githubapp.feature.github.domain.model.Repository
import javax.inject.Inject

interface GithubToDetailsCommand {

    fun navigate(repository: Repository)
}

class GithubToDetailsCommandImpl @Inject constructor(
    private val navigator: Navigator<Activity>
): GithubToDetailsCommand {

    override fun navigate(repository: Repository) {
        navigator.navigate(GithubToDetails(repository))
    }
}