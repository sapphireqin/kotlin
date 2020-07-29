package com.sapphire.daggerviewmodel

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.sapphire.daggerviewmodel.vm.LoginViewModel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var logManager: LogManager

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var loginWithPwdFragment: LoginWithPwdFragment

    @Inject
    lateinit var loginWithPhoneFragment: LoginWithPhoneFragment

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)

        supportFragmentManager.inTransaction {
            add(R.id.login_frame, loginWithPwdFragment)
        }

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
        logManager.doLog("in activity view model = $viewModel, factory = $viewModelFactory")

        viewModel.contentTypeData.observe(this, Observer {
            supportFragmentManager.inTransaction {
                when (it) {
                    LoginWithPwdFragment.TAG -> replace(R.id.login_frame, loginWithPwdFragment)
                    LoginWithPhoneFragment.TAG -> replace(R.id.login_frame, loginWithPhoneFragment)
                    else -> replace(R.id.login_frame, loginWithPwdFragment)
                }

            }
        })

        viewModel.loginResultData.observe(this, Observer {
            logManager.doLog("recv login success")
            Toast.makeText(applicationContext, (if (it) "登录成功" else "登录失败"), Toast.LENGTH_LONG)
                .show()
        })
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }
}