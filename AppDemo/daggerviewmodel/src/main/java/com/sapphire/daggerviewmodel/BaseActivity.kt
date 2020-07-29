package com.sapphire.daggerviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var logManager: LogManager

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    fun <T : ViewModel> getViewModel(modelClass: Class<T>): T {
        return ViewModelProviders.of(this, viewModelFactory).get(modelClass)
    }
}