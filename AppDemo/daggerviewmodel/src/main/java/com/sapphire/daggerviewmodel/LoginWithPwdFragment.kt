package com.sapphire.daggerviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.sapphire.daggerviewmodel.vm.LoginViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.login_with_pwd.*
import javax.inject.Inject

class LoginWithPwdFragment @Inject constructor() : BaseFragment() {

    companion object {
        const val TAG = "LoginWithPwdFragment"
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_with_pwd, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = getViewModel(LoginViewModel::class.java)

        logManager.doLog("in pwd fragment view model = $viewModel, factory = $viewModelFactory")

        phone_login.setOnClickListener {
            viewModel.contentTypeData.value = LoginWithPhoneFragment.TAG
        }

        login_button.setOnClickListener {
            viewModel.login()
        }
    }
}