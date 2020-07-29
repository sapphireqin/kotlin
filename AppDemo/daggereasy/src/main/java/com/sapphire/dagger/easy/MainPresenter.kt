package com.sapphire.dagger.easy

import android.util.Log
import javax.inject.Inject

class MainPresenter @Inject constructor(private val view: IMainView) {
    fun login(name: String, pwd: String) {
        Log.e("sapphire", "login by name $name, pwd $pwd")
        // 调用MainActivity提供的方法
        view.onLoginSuccess()
    }
}