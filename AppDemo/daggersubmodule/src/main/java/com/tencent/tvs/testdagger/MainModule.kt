package com.tencent.tvs.testdagger

import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @Provides
    @ActivityScope
    fun provideMainPresenter(view: IMainView, apiService: ApiService, preferenceManager: PreferenceManager): MainPresenter {
        return MainPresenter(view, apiService, preferenceManager)
    }
}