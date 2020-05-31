package ru.spitchenko.githubapp.feature.auth.presentation

sealed class GoogleSignInResult {

    data class Success(val email: String) : GoogleSignInResult()
    object EmailError : GoogleSignInResult()
    object ApiError : GoogleSignInResult()
}