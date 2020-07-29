package com.sapphire.dagger.easy

import dagger.Component

// 包含modules
@Component(modules = [MainModule::class])
interface MainComponent {
    fun inject(activity: MainActivity);
}