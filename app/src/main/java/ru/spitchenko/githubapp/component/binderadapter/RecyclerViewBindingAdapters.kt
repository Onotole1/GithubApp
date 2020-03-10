package ru.spitchenko.githubapp.component.binderadapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.setBindingList(bindingList: List<BindingClass>?, detectMoves: Boolean? = false) {
	val bindingAdapter = adapter as? BinderAdapter ?: return

	val newOrEmptyList = bindingList.orEmpty()

	val bindingsDiffResult = DiffUtil.calculateDiff(
		BindingDiffUtilCallback(bindingAdapter.itemList, newOrEmptyList), detectMoves ?: false
	)

	bindingAdapter.setItems(bindingsDiffResult, newOrEmptyList)
}