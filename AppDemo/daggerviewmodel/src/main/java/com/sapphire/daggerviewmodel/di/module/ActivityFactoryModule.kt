package com.sapphire.daggerviewmodel.di.module

import com.sapphire.daggerviewmodel.LoginActivity
import com.sapphire.daggerviewmodel.di.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityFactoryModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    fun loginActivityInjector() : LoginActivity
}