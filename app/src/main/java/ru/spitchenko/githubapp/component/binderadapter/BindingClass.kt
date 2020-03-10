package ru.spitchenko.githubapp.component.binderadapter

interface BindingClass {

	val itemId: Long
		get() = this.hashCode().toLong()

	fun areContentsTheSame(other: Any?): Boolean = other?.equals(this) == true

	fun areItemsTheSame(other: Any?): Boolean = (other as? BindingClass)?.itemId == itemId
}