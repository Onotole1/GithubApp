package ru.spitchenko.githubapp.feature.github.search.presentation.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.spitchenko.githubapp.R
import ru.spitchenko.githubapp.component.binderadapter.BindingViewHolder
import ru.spitchenko.githubapp.component.binderadapter.ViewHolderFactory
import ru.spitchenko.githubapp.databinding.ItemRepositorySearchBinding
import ru.spitchenko.githubapp.feature.github.search.presentation.SearchViewModel
import ru.spitchenko.githubapp.feature.github.search.presentation.model.RepositoryUiModel

class RepositoryViewHolderFactory(
    private val viewModel: SearchViewModel
) : ViewHolderFactory<ItemRepositorySearchBinding, RepositoryUiModel> {

    override fun create(parent: ViewGroup): BindingViewHolder<RepositoryUiModel, ItemRepositorySearchBinding> =
        BindingViewHolder<RepositoryUiModel, ItemRepositorySearchBinding>(
            ItemRepositorySearchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            binding.favoriteButton.setOnClickListener {
                val repositoryUiModel = requireNotNull(item)

                if (repositoryUiModel.repository.favorite) {
                    viewModel.removeFromFavorites(repositoryUiModel)
                } else {
                    viewModel.addToFavorites(repositoryUiModel)
                }
            }
        }

    override fun bind(binding: ItemRepositorySearchBinding, model: RepositoryUiModel, payloads: List<Any>) {
        binding.repositoryName.text = model.repository.name
        binding.favoriteButton.setImageResource(
            if (model.repository.favorite) R.drawable.ic_star_black_24dp else R.drawable.ic_star_border_black_24dp
        )
    }
}