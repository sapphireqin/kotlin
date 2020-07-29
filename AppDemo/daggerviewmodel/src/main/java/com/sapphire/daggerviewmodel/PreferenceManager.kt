package com.sapphire.daggerviewmodel

import android.content.SharedPreferences
import javax.inject.Inject

class PreferenceManager constructor(private val preference : SharedPreferences) {

    fun isLogin() : Boolean {
        return false
    }

}