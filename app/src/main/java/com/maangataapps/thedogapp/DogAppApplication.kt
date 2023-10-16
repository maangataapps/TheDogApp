package com.maangataapps.thedogapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DogAppApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }

}