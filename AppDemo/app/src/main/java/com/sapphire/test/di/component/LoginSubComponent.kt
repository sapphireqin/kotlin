package com.sapphire.test.di.component

import com.sapphire.test.LoginActivity
import com.sapphire.test.di.ActivityScope
import com.sapphire.test.di.module.LoginModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [LoginModule::class])
interface LoginSubComponent {
    fun inject(loginActivity: LoginActivity)

    @Subcomponent.Builder
    interface Builder {
        fun build() : LoginSubComponent
    }
}