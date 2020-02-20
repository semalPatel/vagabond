package com.sierra.vagabond.di

import com.sierra.vagabond.data.RecAreaRepository
import com.sierra.vagabond.main.search.MainActivity
import com.sierra.vagabond.main.search.MainController
import com.sierra.vagabond.main.search.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideMainView(mainActivity: MainActivity): MainController.View = mainActivity

    @Provides
    fun provideMainPresenter(mainMvp: MainController.View, recAreaRepository: RecAreaRepository): MainController.ViewModel = MainPresenter(mainMvp, recAreaRepository)

}