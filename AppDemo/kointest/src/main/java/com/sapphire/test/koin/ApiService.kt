package com.sapphire.test.koin

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.get
import retrofit2.Retrofit

class ApiService : KoinComponent{
    private val retrofit: Retrofit = get()
    private val logManager: LogManager = get()

    fun login() : Observable<Boolean> {
        return Observable.create<Boolean> {
            Thread.sleep(3000)
            it.onNext(true)
            it.onComplete()
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

}