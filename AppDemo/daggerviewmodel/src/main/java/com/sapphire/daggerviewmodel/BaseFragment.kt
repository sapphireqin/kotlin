package com.sapphire.daggerviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment : DaggerFragment() {
    @Inject
    lateinit var logManager: LogManager

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    fun <T : ViewModel> getViewModel(modelClass: Class<T>): T {
        // 注意这里需要使用requireActivity，否则Fragment中注入的viewModel将与Activity不一致
        return ViewModelProviders.of(requireActivity(), viewModelFactory).get(modelClass)
    }
}