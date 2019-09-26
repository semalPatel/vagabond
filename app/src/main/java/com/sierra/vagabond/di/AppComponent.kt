package com.sierra.vagabond.di

import android.app.Application
import com.sierra.vagabond.VagabondApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
        AppModule::class,
        BuildersModule::class,
        AndroidInjectionModule::class,
        NetworkModule::class
        ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: VagabondApplication)
}