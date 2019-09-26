package com.sierra.vagabond.di

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.sierra.vagabond.data.local.RecAreaDatabase
import dagger.Module
import dagger.Provides
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideContext(application: Application): Context = application

    @Provides
    fun provideGson(): Gson = Gson()

    @Provides
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory = GsonConverterFactory.create(gson)

    @Singleton
    @Provides
    fun provideDatabase(application: Application) = RecAreaDatabase.getInstance(application)

    @Singleton
    @Provides
    fun provideRecAreaDao(recAreaDatabase: RecAreaDatabase) = recAreaDatabase.recAreaDao()

}