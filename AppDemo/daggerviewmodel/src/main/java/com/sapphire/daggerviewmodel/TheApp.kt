package com.sapphire.daggerviewmodel

import android.app.Activity
import android.app.Application
import com.sapphire.daggerviewmodel.di.component.AppComponent
import com.sapphire.daggerviewmodel.di.component.DaggerAppComponent
import com.sapphire.daggerviewmodel.di.module.AppModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class TheApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().appModule(AppModule(this)).build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }
}