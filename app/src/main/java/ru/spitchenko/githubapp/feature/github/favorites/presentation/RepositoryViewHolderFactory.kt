package ru.spitchenko.githubapp.feature.github.favorites.presentation

import android.os.Bundle
import android.view.ViewGroup
import androidx.navigation.NavController
import ru.spitchenko.githubapp.R
import ru.spitchenko.githubapp.component.binderadapter.BindingViewHolder
import ru.spitchenko.githubapp.component.binderadapter.ViewHolderFactory
import ru.spitchenko.githubapp.component.ui.layoutInflater
import ru.spitchenko.githubapp.databinding.ItemRepositoryBinding
import ru.spitchenko.githubapp.feature.github.details.presentation.model.RepositoryArgs
import ru.spitchenko.githubapp.feature.github.details.presentation.model.repositoryArgs

class RepositoryViewHolderFactory(
    private val navController: NavController
) : ViewHolderFactory<ItemRepositoryBinding, RepositoryUiModel> {

    override fun create(parent: ViewGroup): BindingViewHolder<RepositoryUiModel, ItemRepositoryBinding> =
        BindingViewHolder<RepositoryUiModel, ItemRepositoryBinding>(ItemRepositoryBinding.inflate(
            parent.context.layoutInflater,
            parent,
            false
        )).apply {
            binding.root.setOnClickListener {
                navController.navigate(R.id.action_githubFragment_to_details, Bundle().apply {
                    repositoryArgs = RepositoryArgs(requireNotNull(item).repository)
                })
            }
        }

    override fun bind(
        binding: ItemRepositoryBinding,
        model: RepositoryUiModel,
        payloads: List<Any>
    ) {
        binding.repositoryName.text = model.repository.name
    }
}