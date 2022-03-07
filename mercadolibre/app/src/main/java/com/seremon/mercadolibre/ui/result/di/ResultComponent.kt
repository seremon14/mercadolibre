package com.seremon.mercadolibre.ui.result.di

import com.seremon.mercadolibre.app.di.ActivityScope
import com.seremon.mercadolibre.app.di.AppComponent
import com.seremon.mercadolibre.ui.result.ResultActivity
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [ResultModule::class], dependencies = [AppComponent::class])
interface ResultComponent{

    fun inject(target: ResultActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: ResultActivity): Builder

        fun appComponent(component: AppComponent): Builder

        fun plus(module: ResultModule): Builder

        fun build(): ResultComponent
    }
}