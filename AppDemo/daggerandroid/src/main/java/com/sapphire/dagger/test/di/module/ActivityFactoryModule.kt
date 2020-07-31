package com.sapphire.dagger.test.di.module

import com.sapphire.dagger.test.LoginActivity
import com.sapphire.dagger.test.di.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityFactoryModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    fun loginActivityInjector() : LoginActivity
}