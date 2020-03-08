package ru.spitchenko.githubapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import ru.spitchenko.githubapp.App
import ru.spitchenko.githubapp.component.di.ApplicationScope

@Component(modules = [
	ApplicationModule::class
])
@ApplicationScope
internal interface ApplicationComponent : AndroidInjector<App> {

	@Component.Factory
	interface Factory {

		fun create(@BindsInstance applicationContext: Context): ApplicationComponent
	}
}