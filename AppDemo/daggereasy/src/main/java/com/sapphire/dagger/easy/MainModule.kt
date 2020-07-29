package com.sapphire.dagger.easy

import dagger.Module
import dagger.Provides

@Module
class MainModule constructor(private val view: IMainView) {
    @Provides
    fun provideMainView() : IMainView {
        return view;
    }
}