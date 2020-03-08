package ru.spitchenko.githubapp.component.navigation

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.spitchenko.githubapp.component.di.ActivityScope
import ru.spitchenko.githubapp.component.di.ViewModelKey
import ru.spitchenko.githubapp.component.lifecycle.ViewModelFactory

@Module
class ActivityNavigationModule {

	@Provides
	@IntoMap
	@ViewModelKey(ActivityNavigationViewModel::class)
	fun provideNavigationViewModel(): ViewModel {
		val navigator = NavigatorImpl<Activity>()

		return ActivityNavigationViewModel(navigator = navigator, navigatorProvider = navigator)
	}

	@Provides
	@ActivityScope
	fun provideAppNavigator(
		appCompatActivity: AppCompatActivity,
		viewModelFactory: ViewModelFactory
	): Navigator<Activity> =
		ViewModelProvider(appCompatActivity, viewModelFactory).get<ActivityNavigationViewModel>().navigator

	@Provides
	@ActivityScope
	fun provideAppNavigationProvider(
		appCompatActivity: AppCompatActivity,
		viewModelFactory: ViewModelFactory
	): NavigationActionProvider<Activity> =
		ViewModelProvider(appCompatActivity, viewModelFactory).get<ActivityNavigationViewModel>().navigatorProvider
}