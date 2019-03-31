package com.starwallet.networklayer

import android.app.Application
import com.starwallet.networklayer.data.remote.NetworkModule
import com.starwallet.networklayer.di.ApplicationComponent
import com.starwallet.networklayer.di.DaggerApplicationComponent

class AndroidApplication : Application() {

    companion object {
         lateinit var applicationComponent: ApplicationComponent
    }


    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
            .build()

        applicationComponent.inject(this)
    }


}