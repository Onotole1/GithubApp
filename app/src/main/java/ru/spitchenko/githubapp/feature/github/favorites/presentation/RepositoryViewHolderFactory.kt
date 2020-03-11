package ru.spitchenko.githubapp.feature.github.favorites.presentation

import android.view.ViewGroup
import ru.spitchenko.githubapp.component.binderadapter.BindingViewHolder
import ru.spitchenko.githubapp.component.binderadapter.ViewHolderFactory
import ru.spitchenko.githubapp.component.ui.layoutInflater
import ru.spitchenko.githubapp.databinding.ItemRepositoryBinding
import ru.spitchenko.githubapp.feature.github.navigation.GithubToDetailsCommand

class RepositoryViewHolderFactory(
    private val githubToDetailsCommand: GithubToDetailsCommand
) : ViewHolderFactory<ItemRepositoryBinding, RepositoryUiModel> {

    override fun create(parent: ViewGroup): BindingViewHolder<RepositoryUiModel, ItemRepositoryBinding> =
        BindingViewHolder<RepositoryUiModel, ItemRepositoryBinding>(ItemRepositoryBinding.inflate(
            parent.context.layoutInflater,
            parent,
            false
        )).apply {
            binding.root.setOnClickListener {
                githubToDetailsCommand.navigate(requireNotNull(item).repository)
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