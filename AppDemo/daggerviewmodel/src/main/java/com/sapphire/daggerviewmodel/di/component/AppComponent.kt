package com.sapphire.daggerviewmodel.di.component

import com.sapphire.daggerviewmodel.TheApp
import com.sapphire.daggerviewmodel.di.module.ActivityFactoryModule
import com.sapphire.daggerviewmodel.di.module.AppModule
import com.sapphire.daggerviewmodel.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(modules = [AppModule::class, AndroidInjectionModule::class, ActivityFactoryModule::class])
@Singleton
interface AppComponent {
    fun inject(app: TheApp)
}