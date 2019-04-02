package com.starwallet.networklayer.di.module

import androidx.lifecycle.ViewModelProvider
import com.starwallet.networklayer.di.scope.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}