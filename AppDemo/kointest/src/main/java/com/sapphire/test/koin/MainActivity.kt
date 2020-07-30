package com.sapphire.test.koin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import org.koin.android.ext.android.inject
import org.koin.android.scope.lifecycleScope

class MainActivity : AppCompatActivity() {

    private val preferenceManager: PreferenceManager by inject()
    private val logManager: LogManager by inject()

    private val presenter: MainPresenter by lifecycleScope.inject()

    private val loginWithPhoneFragment: LoginWithPhoneFragment by lifecycleScope.inject()

    private val loginWithPwdFragment: LoginWithPwdFragment by lifecycleScope.inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)
        logManager.doLog("MainActivity presenter $presenter")
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
