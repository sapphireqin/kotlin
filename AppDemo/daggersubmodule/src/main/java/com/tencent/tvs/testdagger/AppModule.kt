package com.tencent.tvs.testdagger

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(subcomponents = [MainComponent::class])
class AppModule constructor(private val context: Context) {
    //提供 全局唯一Application Context 实例
    @Provides
    @Singleton
    fun provideContext() : Context = context

    //提供 全局唯一SharedPreferences 实例
    @Provides
    @Singleton
    fun provideSharedPreference(context: Context) : SharedPreferences
            = context.getSharedPreferences("Sapphire_Pref", Context.MODE_PRIVATE)

    //提供 全局唯一PreferenceManager 实例
    @Provides
    @Singleton
    fun providePreferenceManager(preferences: SharedPreferences) : PreferenceManager
            = PreferenceManager(preferences)


    //提供 全局唯一Retrofit 实例
    @Provides
    @Singleton
    fun provideRemoteClient(): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.HOST_API)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    // 提供全局唯一ApiService实例
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) : ApiService
            = ApiService(retrofit)


    // 提供全局唯一LogManager实例
    @Provides
    @Singleton
    fun provideLogger() : LogManager
            = LogManager()
}