package com.tencent.tvs.testdagger

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: TheApp)

    fun mainComponent(): MainComponent.Builder
}