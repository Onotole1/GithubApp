package ru.spitchenko.githubapp.feature.github.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import dagger.android.support.DaggerFragment
import ru.spitchenko.githubapp.databinding.FragmentGithubBinding

class GithubFragment : DaggerFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGithubBinding.inflate(inflater, container, false)

        val githubPagerAdapter = GithubPagerAdapter(this)

        binding.pager.adapter = githubPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = getString(githubPagerAdapter.getTitle(position))
        }.attach()

        return binding.root
    }
}