package com.sierra.vagabond.di

import android.app.Application
import com.sierra.vagabond.VagabondApplication
import com.sierra.vagabond.main.search.MainActivity
import com.sierra.vagabond.main.search.MainPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
        AppModule::class
        ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun activity(mainActivity: MainActivity): Builder

        fun build(): AppComponent
    }

    fun inject(mainPresenter: MainPresenter)
}