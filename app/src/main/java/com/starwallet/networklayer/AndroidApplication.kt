package com.starwallet.networklayer

import android.app.Application
import com.starwallet.networklayer.di.ApplicationComponent
import com.starwallet.networklayer.di.DaggerApplicationComponent
import com.starwallet.networklayer.di.module.NetworkModule
import com.starwallet.networklayer.di.module.UseCaseModule

class AndroidApplication : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .networkModule(NetworkModule(this))
            .build() }

    override fun onCreate() {
        super.onCreate()
        injectMembers()

    }

    private fun injectMembers() = appComponent.inject(this)

}