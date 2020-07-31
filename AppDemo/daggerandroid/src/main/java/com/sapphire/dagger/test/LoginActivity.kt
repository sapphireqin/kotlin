package com.sapphire.dagger.test

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var logManager: LogManager

    @Inject
    lateinit var presenter: ILoginPresenter

    @Inject
    lateinit var loginWithPwdFragment: LoginWithPwdFragment

    @Inject
    lateinit var loginWithPhoneFragment: LoginWithPhoneFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)

        supportFragmentManager.inTransaction {
            add(R.id.login_frame, loginWithPwdFragment)
        }

        presenter.contentTypeData.observe(this, Observer {
            supportFragmentManager.inTransaction {
                when (it) {
                    LoginWithPwdFragment.TAG -> replace(R.id.login_frame, loginWithPwdFragment)
                    LoginWithPhoneFragment.TAG -> replace(R.id.login_frame, loginWithPhoneFragment)
                    else -> replace(R.id.login_frame, loginWithPwdFragment)
                }

            }
        })

        presenter.loginResultData.observe(this, Observer {
            logManager.doLog("recv login success")
            Toast.makeText(applicationContext, (if (it) "登录成功" else "登录失败"), Toast.LENGTH_LONG)
                .show()
        })
    }
}