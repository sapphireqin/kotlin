package com.sapphire.daggerviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sapphire.daggerviewmodel.vm.LoginViewModel
import kotlinx.android.synthetic.main.login_with_phone.*
import javax.inject.Inject

class LoginWithPhoneFragment @Inject constructor() : BaseFragment() {

    companion object {
        const val TAG = "LoginWithPhoneFragment"
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_with_phone, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = getViewModel(LoginViewModel::class.java)

        logManager.doLog("in phone fragment view model = $viewModel, factory = $viewModelFactory")
        account_login.setOnClickListener {
            viewModel.contentTypeData.value = LoginWithPwdFragment.TAG
        }

        login_button.setOnClickListener {
            viewModel.login()
        }
    }
}