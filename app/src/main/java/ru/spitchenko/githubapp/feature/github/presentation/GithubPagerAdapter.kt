package ru.spitchenko.githubapp.feature.github.presentation

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.spitchenko.githubapp.R
import ru.spitchenko.githubapp.feature.github.favorites.presentation.FavoritesFragment
import ru.spitchenko.githubapp.feature.github.search.presentation.SearchFragment

class GithubPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private enum class Tabs(val id: Long, @StringRes val title: Int, val factory: () -> Fragment) {
        Search(0L, R.string.search, ::SearchFragment),
        Favorites(1L, R.string.favorites, ::FavoritesFragment)
    }

    override fun getItemCount(): Int = Tabs.values().size

    override fun createFragment(position: Int): Fragment = Tabs.values()[position].factory()

    override fun getItemId(position: Int): Long = Tabs.values()[position].id

    @StringRes
    fun getTitle(position: Int): Int = Tabs.values()[position].title
}