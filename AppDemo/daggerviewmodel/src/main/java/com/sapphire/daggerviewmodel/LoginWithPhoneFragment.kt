package com.sapphire.daggerviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.sapphire.daggerviewmodel.di.Injectable
import com.sapphire.daggerviewmodel.vm.LoginViewModel
import kotlinx.android.synthetic.main.login_with_phone.*
import javax.inject.Inject

class LoginWithPhoneFragment @Inject constructor() : Fragment(), Injectable {

    companion object {
        const val TAG = "LoginWithPhoneFragment"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: LoginViewModel

    @Inject
    lateinit var logManager: LogManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_with_phone, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(requireActivity(), viewModelFactory).get(LoginViewModel::class.java)
        logManager.doLog("in phone fragment view model = $viewModel, factory = $viewModelFactory")
        account_login.setOnClickListener {
            viewModel.contentTypeData.value = LoginWithPwdFragment.TAG
        }

        login_button.setOnClickListener {
            viewModel.login()
        }
    }
}