package com.tencent.tvs.testdagger

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity(), IMainView {
    @Inject
    lateinit var mainPresenter: MainPresenter

    @Inject
    lateinit var logManager: LogManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as TheApp).appComponent.mainComponent().view(this).build().inject(this)

        mainPresenter.login("sapphire", "as111111")
    }

    override fun onLoginSuccess() {
        logManager.doLog("onLoginSuccess")
    }
}