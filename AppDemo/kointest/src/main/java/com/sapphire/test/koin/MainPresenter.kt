package com.sapphire.test.koin

import androidx.lifecycle.MutableLiveData
import org.koin.core.KoinComponent
import org.koin.core.get

class MainPresenter : KoinComponent {
    private val apiService: ApiService = get()
    private val preferenceManager: PreferenceManager = get()
    private val logManager: LogManager = get()

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