package ru.spitchenko.githubapp.component.binderadapter

import androidx.collection.ArrayMap
import androidx.viewbinding.ViewBinding
import ru.spitchenko.githubapp.component.collections.arrayMapOf
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
fun <T : BindingClass, VH : ViewHolderFactory<*, *>> binderAdapterOf(vararg factories: Pair<KClass<out T>, VH>): BinderAdapter =
    BinderAdapter(arrayMapOf(factories) as ArrayMap<KClass<out BindingClass>, ViewHolderFactory<ViewBinding, BindingClass>>)

infix fun <M : BindingClass, B : ViewBinding> KClass<M>.bindWith(factory: ViewHolderFactory<B, M>): Pair<KClass<out M>, ViewHolderFactory<B, M>> =
    this to factory