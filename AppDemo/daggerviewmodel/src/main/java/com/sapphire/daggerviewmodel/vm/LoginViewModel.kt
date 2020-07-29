package com.sapphire.daggerviewmodel.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sapphire.daggerviewmodel.ApiService
import com.sapphire.daggerviewmodel.LogManager
import com.sapphire.daggerviewmodel.PreferenceManager
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val logManager: LogManager,
    private val preferenceManager: PreferenceManager,
    private var apiService: ApiService
) : ViewModel() {

    val contentTypeData = MutableLiveData<String>()

    val loginResultData = MutableLiveData<Boolean>()

    fun login() {
        apiService.login().subscribe {
            logManager.doLog("login success")

            loginResultData.value = true
        }

    }
}