package com.sapphire.dagger.easy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), IMainView {
    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 完成注入
        DaggerMainComponent.builder().mainModule(MainModule(this)).build().inject(this)

        login_button.setOnClickListener {
            mainPresenter.login("name", "password")
        }
    }

    override fun onLoginSuccess() {
        Log.e("sapphire", "onLoginSuccess")
    }
}
