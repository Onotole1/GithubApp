package ru.spitchenko.githubapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.fragment.android.setupKoinFragmentFactory

class AppActivity : AppCompatActivity(R.layout.activity_app) {

    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoinFragmentFactory()

        super.onCreate(savedInstanceState)
    }
}
