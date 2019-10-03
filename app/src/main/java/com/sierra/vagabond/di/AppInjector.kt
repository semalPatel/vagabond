package com.sierra.vagabond.di

import com.sierra.vagabond.VagabondApplication

object AppInjector {

    fun init(application: VagabondApplication) {
        DaggerAppComponent.builder().application(application)
                .build().inject(application)
    }
}