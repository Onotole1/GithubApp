package ru.spitchenko.githubapp.feature.github.favorites.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import dagger.android.support.DaggerFragment
import ru.spitchenko.githubapp.component.binderadapter.bindWith
import ru.spitchenko.githubapp.component.binderadapter.binderAdapterOf
import ru.spitchenko.githubapp.component.binderadapter.setBindingList
import ru.spitchenko.githubapp.component.lifecycle.ViewModelProviders
import ru.spitchenko.githubapp.component.lifecycle.viewModels
import ru.spitchenko.githubapp.databinding.FragmentFavoritesBinding
import ru.spitchenko.githubapp.feature.github.navigation.GithubToDetailsCommand
import javax.inject.Inject

class FavoritesFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelProviders: ViewModelProviders

    @Inject
    lateinit var githubToDetailsCommand: GithubToDetailsCommand

    private val viewModel: FavoritesViewModel by viewModels { viewModelProviders }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFavoritesBinding.inflate(layoutInflater, container, false)

        viewModel.favorites.observe(viewLifecycleOwner) { repositories ->
            binding.favoritesList.setBindingList(repositories)

            if (repositories.isEmpty()) {
                binding.emptyText.visibility = View.VISIBLE
            } else {
                binding.emptyText.visibility = View.GONE
            }
        }

        binding.favoritesList.adapter = binderAdapterOf(
            RepositoryUiModel::class bindWith RepositoryViewHolderFactory(githubToDetailsCommand)
        )

        return binding.root
    }
}