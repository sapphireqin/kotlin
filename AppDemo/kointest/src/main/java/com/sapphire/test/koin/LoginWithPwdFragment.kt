package com.sapphire.test.koin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.login_with_pwd.*
import org.koin.android.ext.android.inject

class LoginWithPwdFragment(private val presenter: MainPresenter) : Fragment() {

    companion object {
        const val TAG = "LoginWithPwdFragment"
    }

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

        logManager.doLog("$TAG presenter $presenter")

        phone_login.setOnClickListener {
            presenter.contentTypeData.value = LoginWithPhoneFragment.TAG
        }

        login_button.setOnClickListener {
            presenter.login()
        }
    }
}