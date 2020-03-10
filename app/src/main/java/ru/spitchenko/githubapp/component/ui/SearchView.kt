package ru.spitchenko.githubapp.component.ui

import androidx.appcompat.widget.SearchView

fun SearchView.onQueryTextChange(onQueryTextChange: (String) -> Unit) {
    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean = false

        override fun onQueryTextChange(newText: String?): Boolean {
            onQueryTextChange.invoke(newText.orEmpty())
            return true
        }
    })
}