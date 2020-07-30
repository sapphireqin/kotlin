package com.sapphire.test.koin

import android.content.SharedPreferences

class PreferenceManager constructor(private val preference : SharedPreferences, private val  logManager: LogManager) {
    fun isLogin() : Boolean {
        logManager.doLog("PreferenceManager call isLogin")
        return false
    }

}