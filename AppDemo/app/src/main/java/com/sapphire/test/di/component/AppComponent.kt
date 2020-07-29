package com.sapphire.test.di.component

import com.sapphire.test.TheApp
import com.sapphire.test.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: TheApp)

    fun loginSubComponent() : LoginSubComponent.Builder
}