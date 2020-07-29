package com.sapphire.daggerviewmodel.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sapphire.daggerviewmodel.di.ViewModelKey
import com.sapphire.daggerviewmodel.vm.LoginViewModel
import com.sapphire.daggerviewmodel.vm.AppViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun loginViewModel(viewModel: LoginViewModel) : ViewModel

    // TO-DO 其他ViewModel在这里定义

    // 绑定全局唯一ViewModel Factory实例
    @Binds
    fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}