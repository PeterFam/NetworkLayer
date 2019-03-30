package com.starwallet.networklayer

import android.app.Application
import com.starwallet.networklayer.di.ApplicationComponent

class AndroidApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()


    }


}