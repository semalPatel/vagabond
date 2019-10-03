package com.sierra.vagabond

import android.app.Application
import com.sierra.vagabond.di.AppComponent
import com.sierra.vagabond.di.AppInjector
import com.sierra.vagabond.di.DaggerAppComponent
import com.sierra.vagabond.utils.Prefs
import com.sierra.vagabond.utils.PushInteractor
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class VagabondApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>

    private val pushInteractor = PushInteractor()

    override fun onCreate() {
        super.onCreate()
        pushInteractor.registerDeviceToken()
        Prefs.init(this)
        AppInjector.init(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}