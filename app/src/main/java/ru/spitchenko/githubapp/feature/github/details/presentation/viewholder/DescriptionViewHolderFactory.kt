package ru.spitchenko.githubapp.feature.github.details.presentation.viewholder

import android.view.ViewGroup
import ru.spitchenko.githubapp.component.binderadapter.BindingViewHolder
import ru.spitchenko.githubapp.component.binderadapter.ViewHolderFactory
import ru.spitchenko.githubapp.component.ui.layoutInflater
import ru.spitchenko.githubapp.databinding.ItemDescriptionBinding
import ru.spitchenko.githubapp.feature.github.details.presentation.model.DescriptionUiModel

object DescriptionViewHolderFactory :
    ViewHolderFactory<ItemDescriptionBinding, DescriptionUiModel> {

    override fun create(parent: ViewGroup): BindingViewHolder<DescriptionUiModel, ItemDescriptionBinding> =
        BindingViewHolder(
            ItemDescriptionBinding.inflate(
                parent.context.layoutInflater,
                parent,
                false
            )
        )

    override fun bind(
        binding: ItemDescriptionBinding,
        model: DescriptionUiModel,
        payloads: List<Any>
    ) {
        binding.title.text = model.title
        binding.description.text = model.description
    }
}