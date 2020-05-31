package ru.spitchenko.githubapp.feature.github.favorites.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import org.koin.android.viewmodel.ext.android.viewModel
import ru.spitchenko.githubapp.component.binderadapter.bindWith
import ru.spitchenko.githubapp.component.binderadapter.binderAdapterOf
import ru.spitchenko.githubapp.component.binderadapter.setBindingList
import ru.spitchenko.githubapp.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {

    private val viewModel: FavoritesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFavoritesBinding.inflate(layoutInflater, container, false)

        viewModel.favorites.observe(viewLifecycleOwner) { repositories ->
            binding.favoritesList.setBindingList(repositories)

            binding.emptyText.isVisible = repositories.isEmpty()
        }

        binding.favoritesList.adapter = binderAdapterOf(
            RepositoryUiModel::class bindWith RepositoryViewHolderFactory(findNavController())
        )

        return binding.root
    }
}