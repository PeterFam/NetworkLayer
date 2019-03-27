package com.starwallet.networklayer.data.remote

import android.app.Application
import android.content.Context
import com.starwallet.networklayer.BuildConfig
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

}