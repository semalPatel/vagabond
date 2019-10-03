package com.sierra.vagabond.di

import com.sierra.vagabond.main.details.DetailsActivity
import com.sierra.vagabond.main.details.DetailsMvp
import com.sierra.vagabond.main.details.DetailsPresenter
import dagger.Module
import dagger.Provides

@Module
class DetailsActivityModule {

    @Provides
    fun provideMainView(detailsActivity: DetailsActivity): DetailsMvp.View = detailsActivity

    @Provides
    fun provideMainPresenter(detailsMvp: DetailsMvp.View): DetailsMvp.Presenter = DetailsPresenter(detailsMvp)
}