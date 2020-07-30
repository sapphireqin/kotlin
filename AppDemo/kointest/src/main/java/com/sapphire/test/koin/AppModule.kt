package com.sapphire.test.koin

import android.content.Context
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single<SharedPreferences> {
        androidContext().getSharedPreferences(
            "Sapphire_Pref",
            Context.MODE_PRIVATE
        )
    }

    single { PreferenceManager(get(), get()) }

    single { LogManager() }

    single {
        Retrofit.Builder()
            .baseUrl(Constants.HOST_API)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { ApiService() }

    scope(named<MainActivity>()) {
        scoped { MainPresenter() }

        scoped { LoginWithPhoneFragment(get()) }

        scoped { LoginWithPwdFragment(get()) }
    }
}