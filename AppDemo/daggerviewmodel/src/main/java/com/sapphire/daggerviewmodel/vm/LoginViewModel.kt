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
    // 用于Fragment切换
    val contentTypeData = MutableLiveData<String>()
    // 用于将登陆结果通知UI
    val loginResultData = MutableLiveData<Boolean>()

    // 登录
    fun login() {
        apiService.login().subscribe {
            logManager.doLog("login success")
            // 登陆成功后通过LiveData通知UI
            loginResultData.value = true
        }

    }
}