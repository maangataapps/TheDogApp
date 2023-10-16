package com.maangataapps.thedogapp

import android.app.Application
import com.maangataapps.thedogapp.infrastructure.localstore.ObjectBox
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DogAppApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        ObjectBox.init(this)
    }

}