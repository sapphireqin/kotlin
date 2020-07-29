package com.sapphire.daggerviewmodel.di.module

import com.sapphire.daggerviewmodel.LoginWithPhoneFragment
import com.sapphire.daggerviewmodel.LoginWithPwdFragment
import com.sapphire.daggerviewmodel.di.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface LoginActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun loginWithPwdFragmentInjector() : LoginWithPwdFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun loginWithPhoneFragmentInjector() : LoginWithPhoneFragment
}