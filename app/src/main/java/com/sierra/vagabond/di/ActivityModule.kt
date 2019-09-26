package com.sierra.vagabond.di

import com.sierra.vagabond.data.RecAreaRepository
import com.sierra.vagabond.main.search.MainActivity
import com.sierra.vagabond.main.search.MainMvp
import com.sierra.vagabond.main.search.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideMainView(mainActivity: MainActivity): MainMvp.View = mainActivity

    @Provides
    fun provideMainPresenter(mainMvp: MainMvp.View, recAreaRepository: RecAreaRepository): MainMvp.Presenter = MainPresenter(mainMvp, recAreaRepository)

}