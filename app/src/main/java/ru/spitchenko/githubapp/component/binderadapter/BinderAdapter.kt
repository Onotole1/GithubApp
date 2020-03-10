package ru.spitchenko.githubapp.component.binderadapter

import android.view.ViewGroup
import androidx.collection.ArrayMap
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KClass

class BinderAdapter(
    private val factory: ArrayMap<KClass<out BindingClass>, ViewHolderFactory<ViewBinding, BindingClass>>
) : RecyclerView.Adapter<BindingViewHolder<BindingClass, ViewBinding>>() {

    var itemList: List<BindingClass> = emptyList()
        private set

    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int): Int {
        val bindingItem = itemList.getOrNull(position) ?: return super.getItemViewType(position)

        return factory.indexOfKey(bindingItem::class)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<BindingClass, ViewBinding> =
        factory.valueAt(viewType).create(parent)

    fun setItems(diffResult: DiffUtil.DiffResult, items: List<BindingClass>) {
        itemList = items
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onBindViewHolder(
        holder: BindingViewHolder<BindingClass, ViewBinding>,
        position: Int
    ) = Unit

    override fun onBindViewHolder(
        holder: BindingViewHolder<BindingClass, ViewBinding>,
        position: Int,
        payloads: MutableList<Any>
    ) {
        val model = itemList.getOrNull(position) ?: return
        holder.item = model
        val factory = factory.getValue(model::class)
        factory.bind(holder.binding, model, payloads)
    }
}