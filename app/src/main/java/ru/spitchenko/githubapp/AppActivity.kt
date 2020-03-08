package ru.spitchenko.githubapp

import android.app.Activity
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import ru.spitchenko.githubapp.component.navigation.NavigationActionProvider
import javax.inject.Inject

class AppActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var navigationActionProvider: NavigationActionProvider<Activity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        navigationActionProvider.bind(source = this, lifecycleOwner = this)
    }
}
