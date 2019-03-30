package com.starwallet.networklayer.di

import com.starwallet.networklayer.AndroidApplication
import com.starwallet.networklayer.data.remote.NetworkModule
import com.starwallet.networklayer.di.scope.AppScope
import dagger.Component
import javax.inject.Singleton


@AppScope
@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(application: AndroidApplication)
}
