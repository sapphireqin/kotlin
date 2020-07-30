package com.sapphire.test.koin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel constructor(
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