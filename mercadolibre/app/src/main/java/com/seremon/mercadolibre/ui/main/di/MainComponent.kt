package com.seremon.mercadolibre.ui.main.di

import com.seremon.mercadolibre.app.di.ActivityScope
import com.seremon.mercadolibre.app.di.AppComponent
import com.seremon.mercadolibre.ui.main.MainActivity
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [MainModule::class], dependencies = [AppComponent::class])
interface MainComponent {

    fun inject(target: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: MainActivity): Builder

        fun appComponent(component: AppComponent): Builder

        fun plus(module: MainModule): Builder

        fun build(): MainComponent
    }
}