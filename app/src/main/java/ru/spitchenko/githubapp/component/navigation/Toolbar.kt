package ru.spitchenko.githubapp.component.navigation

import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController

fun Toolbar.initToolbar(navController: NavController) {
    val appBarConfiguration = AppBarConfiguration(navController.graph)

    setupWithNavController(navController, appBarConfiguration)
}