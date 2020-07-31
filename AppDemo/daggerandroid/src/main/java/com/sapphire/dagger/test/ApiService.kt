package com.sapphire.dagger.test

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class ApiService constructor(private val retrofit: Retrofit) {

    fun login() : Observable<Boolean> {
        return Observable.create<Boolean> {
            Thread.sleep(3000)
            it.onNext(true)
            it.onComplete()
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

}