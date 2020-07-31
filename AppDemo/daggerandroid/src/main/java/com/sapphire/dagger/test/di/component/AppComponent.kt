package com.sapphire.dagger.test.di.component

import com.sapphire.dagger.test.TheApp
import com.sapphire.dagger.test.di.module.ActivityFactoryModule
import com.sapphire.dagger.test.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(modules = [AppModule::class, AndroidInjectionModule::class, ActivityFactoryModule::class])
@Singleton
interface AppComponent {
    fun inject(app: TheApp)
}