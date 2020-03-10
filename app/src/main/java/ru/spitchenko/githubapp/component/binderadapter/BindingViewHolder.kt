package ru.spitchenko.githubapp.component.binderadapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class BindingViewHolder<M: BindingClass, out B : ViewBinding>(
	val binding: B
) : RecyclerView.ViewHolder(binding.root) {

	var item: M? = null
}