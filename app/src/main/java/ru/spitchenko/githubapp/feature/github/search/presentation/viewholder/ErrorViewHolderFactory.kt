package ru.spitchenko.githubapp.feature.github.search.presentation.viewholder

import android.view.ViewGroup
import ru.spitchenko.githubapp.component.binderadapter.BindingViewHolder
import ru.spitchenko.githubapp.component.binderadapter.ViewHolderFactory
import ru.spitchenko.githubapp.component.ui.getString
import ru.spitchenko.githubapp.component.ui.layoutInflater
import ru.spitchenko.githubapp.databinding.ItemErrorBinding
import ru.spitchenko.githubapp.feature.github.search.presentation.SearchViewModel
import ru.spitchenko.githubapp.feature.github.search.presentation.model.ErrorUiModel

class ErrorViewHolderFactory(
    private val viewModel: SearchViewModel
) : ViewHolderFactory<ItemErrorBinding, ErrorUiModel> {

    override fun create(parent: ViewGroup): BindingViewHolder<ErrorUiModel, ItemErrorBinding> =
        BindingViewHolder<ErrorUiModel, ItemErrorBinding>(
            ItemErrorBinding.inflate(
                parent.context.layoutInflater,
                parent,
                false
            )
        ).apply {
            binding.itemErrorRetryButton.setOnClickListener {
                viewModel.retry()
            }
        }

    override fun bind(binding: ItemErrorBinding, model: ErrorUiModel, payloads: List<Any>) {
        binding.itemErrorMessage.text = model.error.getString(binding.root.context)
    }
}