package com.sierra.vagabond.di

import com.sierra.vagabond.main.details.DetailsActivity
import com.sierra.vagabond.main.search.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [(DetailsActivityModule::class)])
    abstract fun bindDetailsActivity(): DetailsActivity

    // Add bindings for other sub-components here
}