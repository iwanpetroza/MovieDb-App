package com.petroza.mandiri.exercise.moviedbapp

import android.app.Application
import com.petroza.mandiri.exercise.moviedbapp.login.data.PreferencesProvider

class MovieAppAplication: Application() {

    override fun onCreate() {
        super.onCreate()
        PreferencesProvider.init(this)
    }
}