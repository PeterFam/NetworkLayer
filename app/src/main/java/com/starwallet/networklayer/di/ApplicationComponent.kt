package com.starwallet.networklayer.di

import com.starwallet.networklayer.AndroidApplication
import com.starwallet.networklayer.di.module.NetworkModule
import com.starwallet.networklayer.di.module.UseCaseModule
import com.starwallet.networklayer.di.module.ViewModelModule
import com.starwallet.networklayer.ui.BaseActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class, UseCaseModule::class])
interface ApplicationComponent {

    fun inject(application: AndroidApplication)
    fun inject(baseActivity: BaseActivity)
}
