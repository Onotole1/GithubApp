package ru.spitchenko.githubapp.feature.github.details.presentation.viewholder

import android.view.ViewGroup
import ru.spitchenko.githubapp.R
import ru.spitchenko.githubapp.component.binderadapter.BindingViewHolder
import ru.spitchenko.githubapp.component.binderadapter.ViewHolderFactory
import ru.spitchenko.githubapp.component.glide.setImageGlide
import ru.spitchenko.githubapp.component.ui.layoutInflater
import ru.spitchenko.githubapp.databinding.ItemAuthorBinding
import ru.spitchenko.githubapp.feature.github.details.presentation.model.AuthorUiModel

object AuthorViewHolderFactory: ViewHolderFactory<ItemAuthorBinding, AuthorUiModel> {

    override fun create(parent: ViewGroup): BindingViewHolder<AuthorUiModel, ItemAuthorBinding> =
        BindingViewHolder(ItemAuthorBinding.inflate(parent.context.layoutInflater, parent, false))

    override fun bind(binding: ItemAuthorBinding, model: AuthorUiModel, payloads: List<Any>) {
        binding.imageAvatar.setImageGlide(model.avatar, R.drawable.ic_account_circle_black_24dp)
        binding.textAuthor.text = model.name
    }
}