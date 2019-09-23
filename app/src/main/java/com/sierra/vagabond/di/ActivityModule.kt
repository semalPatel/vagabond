package com.sierra.vagabond.di

import com.sierra.vagabond.data.SearchRepositoryProvider
import com.sierra.vagabond.main.search.MainActivity
import com.sierra.vagabond.main.search.MainMvp
import com.sierra.vagabond.main.search.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideMainview(mainActivity: MainActivity): MainMvp.View = mainActivity

    @Provides
    fun provideMainPresenter(mainMvp: MainMvp.View, searchRepositoryProvider: SearchRepositoryProvider): MainMvp.Presenter = MainPresenter(mainMvp, searchRepositoryProvider)

}