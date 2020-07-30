package com.sapphire.test.koin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.login_with_pwd.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class LoginWithPwdFragment() : Fragment() {

    companion object {
        const val TAG = "LoginWithPwdFragment"
    }

    private lateinit var loginViewModel: LoginViewModel

    private val logManager: LogManager by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_with_pwd, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginViewModel = ViewModelProviders.of(requireActivity()).get(LoginViewModel::class.java)

        logManager.doLog("$TAG presenter $loginViewModel")

        phone_login.setOnClickListener {
            loginViewModel.contentTypeData.value = LoginWithPhoneFragment.TAG
        }

        login_button.setOnClickListener {
            loginViewModel.login()
        }
    }
}