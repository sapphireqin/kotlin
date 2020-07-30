package com.sapphire.test.koin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.login_with_phone.*
import org.koin.android.ext.android.inject

class LoginWithPhoneFragment(private val presenter: MainPresenter) : Fragment() {

    companion object {
        const val TAG = "LoginWithPhoneFragment"
    }

    private val logManager:LogManager by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_with_phone, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        logManager.doLog("$TAG presenter $presenter")

        account_login.setOnClickListener {
            presenter.contentTypeData.value = LoginWithPwdFragment.TAG
        }

        login_button.setOnClickListener {
            presenter.login()
        }
    }
}