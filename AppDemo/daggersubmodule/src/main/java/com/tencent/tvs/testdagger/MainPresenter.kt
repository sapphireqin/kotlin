package com.tencent.tvs.testdagger

import javax.inject.Inject

interface IMainView {
    fun onLoginSuccess()
}

class MainPresenter constructor(
    private val view: IMainView,
    private val apiService: ApiService,
    private val preferenceManager: PreferenceManager
) {
    @Inject
    lateinit var logManager: LogManager

    fun login(name: String, pwd: String) {

        logManager.doLog("login by name $name, pwd $pwd")
        apiService.login()
        view.onLoginSuccess()
    }
}