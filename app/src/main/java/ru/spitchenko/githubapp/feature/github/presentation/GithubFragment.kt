package ru.spitchenko.githubapp.feature.github.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import dagger.android.support.DaggerFragment
import ru.spitchenko.githubapp.R
import ru.spitchenko.githubapp.component.lifecycle.ViewModelProviders
import ru.spitchenko.githubapp.component.lifecycle.viewModels
import ru.spitchenko.githubapp.databinding.FragmentGithubBinding
import javax.inject.Inject

class GithubFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelProviders: ViewModelProviders

    private val githubViewModel: GithubViewModel by viewModels { viewModelProviders }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGithubBinding.inflate(inflater, container, false)

        val githubPagerAdapter = GithubPagerAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)

        binding.pager.adapter = githubPagerAdapter

        binding.pager.isUserInputEnabled = false

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = getString(githubPagerAdapter.getTitle(position))
        }.attach()

        binding.toolbar.title = getString(R.string.app_name)
        binding.toolbar.inflateMenu(R.menu.github_menu)
        binding.toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.menu_exit) {
                githubViewModel.logout()
                return@setOnMenuItemClickListener true
            }

            false
        }

        return binding.root
    }
}