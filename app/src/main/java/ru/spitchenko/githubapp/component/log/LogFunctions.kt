package ru.spitchenko.githubapp.component.log

import timber.log.Timber

fun debug(message: String) = Timber.d(message)

fun info(message: String) = Timber.i(message)

fun warning(message: String) = Timber.w(message)