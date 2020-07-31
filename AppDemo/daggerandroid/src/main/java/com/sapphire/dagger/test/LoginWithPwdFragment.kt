package com.sapphire.dagger.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.login_with_phone.*
import kotlinx.android.synthetic.main.login_with_pwd.*
import kotlinx.android.synthetic.main.login_with_pwd.login_button
import javax.inject.Inject

class LoginWithPwdFragment @Inject constructor() : DaggerFragment() {

    companion object {
        const val TAG = "LoginWithPwdFragment"
    }

    @Inject
    lateinit var presenter: ILoginPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_with_pwd, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        phone_login.setOnClickListener {
            presenter.contentTypeData.value = LoginWithPhoneFragment.TAG
        }

        login_button.setOnClickListener {
            presenter.login()
        }
    }
}