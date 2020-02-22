package com.sierra.vagabond

import android.app.Application
import com.sierra.vagabond.di.AppInjector
import com.sierra.vagabond.utils.Prefs
import com.sierra.vagabond.utils.PushInteractor
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class VagabondApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>

    private val pushInteractor = PushInteractor()

    override fun onCreate() {
        super.onCreate()
        Prefs.init(this)
        AppInjector.init(this)
        registerToken()
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    private fun registerToken() {
        CoroutineScope(Dispatchers.Default).launch {
            pushInteractor.registerDeviceToken()
        }
    }
}