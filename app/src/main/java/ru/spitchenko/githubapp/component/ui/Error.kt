package ru.spitchenko.githubapp.component.ui

import android.content.Context
import ru.spitchenko.githubapp.R
import ru.spitchenko.githubapp.component.network.NetworkError

fun NetworkError.getString(context: Context): String =
    when (this) {
        NetworkError.NoInternet -> R.string.no_network_error
        NetworkError.TooManyRequests -> R.string.too_many_requests
    }.let(context::getString)