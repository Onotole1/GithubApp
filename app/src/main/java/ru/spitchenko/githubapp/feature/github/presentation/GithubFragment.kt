package ru.spitchenko.githubapp.feature.github.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.android.viewmodel.ext.android.viewModel
import ru.spitchenko.githubapp.R
import ru.spitchenko.githubapp.databinding.FragmentGithubBinding

class GithubFragment : Fragment() {

    private val githubViewModel: GithubViewModel by viewModel()

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

        githubViewModel.logoutEvent.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_logout)
        }

        return binding.root
    }
}