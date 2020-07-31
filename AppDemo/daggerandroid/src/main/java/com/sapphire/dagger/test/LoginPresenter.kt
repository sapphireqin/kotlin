package com.sapphire.dagger.test

import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import javax.inject.Inject

interface ILoginPresenter {
    val contentTypeData: MutableLiveData<String>

    val loginResultData: MutableLiveData<Boolean>

    fun login()
}

class LoginPresenter @Inject constructor() : ILoginPresenter {

    @Inject
    lateinit var logManager: LogManager

    @Inject
    lateinit var preferenceManager: PreferenceManager

    @Inject
    lateinit var apiService: ApiService

    override val contentTypeData = MutableLiveData<String>()

    override val loginResultData = MutableLiveData<Boolean>()

    override fun login() {
        apiService.login().subscribe {
            logManager.doLog("login success")

            loginResultData.value = true
        }

    }

}