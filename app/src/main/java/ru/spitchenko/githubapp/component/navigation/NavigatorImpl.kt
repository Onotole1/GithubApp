package ru.spitchenko.githubapp.component.navigation

import androidx.lifecycle.LifecycleOwner
import ru.spitchenko.githubapp.component.lifecycle.MutableSingleLiveEvent

class NavigatorImpl<T> : Navigator<T>, NavigationActionProvider<T> {

	private val navigationEvent = MutableSingleLiveEvent<NavigationTarget<T>>()

	override fun navigate(target: NavigationTarget<T>) {
		navigationEvent.sendEvent(target)
	}

	override fun bind(source: T, lifecycleOwner: LifecycleOwner) {
		navigationEvent.observe(lifecycleOwner) {
			it.navigate(source)
		}
	}
}