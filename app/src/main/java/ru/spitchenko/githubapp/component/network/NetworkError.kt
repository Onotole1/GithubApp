package ru.spitchenko.githubapp.component.network

sealed class NetworkError {

    object NoInternet: NetworkError()
    object TooManyRequests: NetworkError()
}