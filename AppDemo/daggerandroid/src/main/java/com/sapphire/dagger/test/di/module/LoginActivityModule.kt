package com.sapphire.dagger.test.di.module

import com.sapphire.dagger.test.ILoginPresenter
import com.sapphire.dagger.test.LoginPresenter
import com.sapphire.dagger.test.LoginWithPhoneFragment
import com.sapphire.dagger.test.LoginWithPwdFragment
import com.sapphire.dagger.test.di.ActivityScope
import com.sapphire.dagger.test.di.FragmentScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Named

@Module
interface LoginActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun loginWithPwdFragmentInjector() : LoginWithPwdFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun loginWithPhoneFragmentInjector() : LoginWithPhoneFragment

    @Binds
    @ActivityScope
    fun provideLoginPresenter(presenter : LoginPresenter) : ILoginPresenter
}