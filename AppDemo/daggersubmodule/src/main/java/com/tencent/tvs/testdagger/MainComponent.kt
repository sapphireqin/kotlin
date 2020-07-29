package com.tencent.tvs.testdagger

import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [MainModule::class])
interface MainComponent {
    fun inject(activity: MainActivity);

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun view(view: IMainView): Builder

        fun build(): MainComponent
    }
}