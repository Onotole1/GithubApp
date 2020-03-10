package ru.spitchenko.githubapp.component.ui

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

inline fun RecyclerView.onScrolledToFooter(crossinline action: () -> Unit) {
    addOnScrollListener(
        object : RecyclerView.OnScrollListener() {

            private val linearLayoutManager = layoutManager as LinearLayoutManager

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                with(linearLayoutManager) {
                    val visibleItemCount = childCount
                    val firstVisibleItemPosition = findFirstVisibleItemPosition()
                    val totalItemCount = itemCount

                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount) {
                        post {
                            action()
                        }
                    }
                }
            }
        })
}