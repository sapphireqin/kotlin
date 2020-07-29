package com.sapphire.daggerviewmodel

import android.app.Activity
import android.app.Application
import com.sapphire.daggerviewmodel.di.AppInjector
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

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()

        appComponent.inject(this)

        AppInjector.init(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }


}