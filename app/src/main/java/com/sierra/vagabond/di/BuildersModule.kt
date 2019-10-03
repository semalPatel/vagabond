package com.sierra.vagabond.di

import com.sierra.vagabond.main.search.MainActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector


@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity(): MainActivity

    // Add bindings for other sub-components here
}