package ru.spitchenko.githubapp.component.navigation

import android.app.Activity
import androidx.lifecycle.ViewModel

class ActivityNavigationViewModel(
	val navigator: Navigator<Activity>,
	val navigatorProvider: NavigationActionProvider<Activity>
) : ViewModel()