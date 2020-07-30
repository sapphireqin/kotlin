package com.sapphire.test.koin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.login_with_phone.*
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject

class LoginWithPhoneFragment() : Fragment() {

    companion object {
        const val TAG = "LoginWithPhoneFragment"
    }

    private val logManager:LogManager by inject()

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_with_phone, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginViewModel = ViewModelProviders.of(requireActivity()).get(LoginViewModel::class.java)
        logManager.doLog("$TAG presenter $loginViewModel")

        account_login.setOnClickListener {
            loginViewModel.contentTypeData.value = LoginWithPwdFragment.TAG
        }

        login_button.setOnClickListener {
            loginViewModel.login()
        }
    }
}