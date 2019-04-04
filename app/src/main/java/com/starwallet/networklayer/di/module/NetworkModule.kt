package com.starwallet.networklayer.di.module

import android.app.Application
import android.content.Context
import com.starwallet.networklayer.BuildConfig
import com.starwallet.networklayer.data.remote.SettingsAPI
import com.starwallet.networklayer.repository.NetworkRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule (private val application: Application){

    @Provides @Singleton fun providesApplicationContext(): Context = application

    @Provides @Singleton fun providesRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(SettingsAPI.baseUrl)
            .client(createClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }
        return okHttpClientBuilder.build()
    }

    @Provides @Singleton fun provideNetworkModule(dataSource: NetworkRepository.Network): NetworkRepository = dataSource

}