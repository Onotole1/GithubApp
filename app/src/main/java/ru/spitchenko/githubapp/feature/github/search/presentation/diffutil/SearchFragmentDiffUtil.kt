package ru.spitchenko.githubapp.feature.github.search.presentation.diffutil

import ru.spitchenko.githubapp.component.binderadapter.BindingClass
import ru.spitchenko.githubapp.component.binderadapter.BindingDiffUtilCallback
import ru.spitchenko.githubapp.feature.github.search.presentation.model.RepositoryUiModel

class SearchFragmentDiffUtil(
    private val oldItems: List<BindingClass>,
    private val newItems: List<BindingClass>
) : BindingDiffUtilCallback(oldItems, newItems) {

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        val oldItem = oldItems[oldItemPosition] as? RepositoryUiModel ?: return null
        val newItem = newItems[newItemPosition] as? RepositoryUiModel ?: return null

        if (oldItem.repository.favorite != newItem.repository.favorite) {
            return RepositoryChange(newItem.repository.favorite)
        }

        return null
    }
}