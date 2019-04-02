package com.starwallet.networklayer.di

import com.starwallet.networklayer.AndroidApplication
import com.starwallet.networklayer.di.module.NetworkModule
import com.starwallet.networklayer.di.module.ViewModelModule
import com.starwallet.networklayer.ui.login.LoginActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(application: AndroidApplication)

}
