package ru.spitchenko.githubapp.feature.github.favorites.presentation

import android.view.ViewGroup
import ru.spitchenko.githubapp.component.binderadapter.BindingViewHolder
import ru.spitchenko.githubapp.component.binderadapter.ViewHolderFactory
import ru.spitchenko.githubapp.component.ui.layoutInflater
import ru.spitchenko.githubapp.databinding.ItemRepositoryBinding

class RepositoryViewHolderFactory : ViewHolderFactory<ItemRepositoryBinding, RepositoryUiModel> {

    override fun create(parent: ViewGroup): BindingViewHolder<RepositoryUiModel, ItemRepositoryBinding> =
        BindingViewHolder(ItemRepositoryBinding.inflate(
            parent.context.layoutInflater,
            parent,
            false
        ))

    override fun bind(
        binding: ItemRepositoryBinding,
        model: RepositoryUiModel,
        payloads: List<Any>
    ) {
        binding.repositoryName.text = model.repository.name
    }
}