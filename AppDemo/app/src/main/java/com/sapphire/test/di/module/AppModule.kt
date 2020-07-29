package com.sapphire.test.di.module

import android.content.Context
import android.content.SharedPreferences
import com.sapphire.test.ApiService
import com.sapphire.test.Constants
import com.sapphire.test.LogManager
import com.sapphire.test.PreferenceManager
import com.sapphire.test.di.component.LoginSubComponent
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(subcomponents = [LoginSubComponent::class])
class AppModule constructor(private val context: Context) {

    @Provides
    @Singleton
    fun provideContext() : Context {
        return context;
    }

    @Provides
    @Singleton
    fun provideSharedPreference(context: Context) : SharedPreferences {
        return context.getSharedPreferences("Sapphire_Pref", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providePreferenceManager(preferences: SharedPreferences) : PreferenceManager {
        return PreferenceManager(preferences)
    }

    //提供 Retrofit 实例
    @Provides
    @Singleton
    fun provideRemoteClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.HOST_API)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) : ApiService {
        return ApiService(retrofit)
    }

    @Provides
    @Singleton
    fun provideLogger() : LogManager {
        return LogManager()
    }
}