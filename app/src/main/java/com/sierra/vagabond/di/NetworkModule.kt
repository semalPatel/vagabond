package com.sierra.vagabond.di

import com.sierra.vagabond.api.AreasApiService
import com.sierra.vagabond.api.AuthInterceptor
import com.sierra.vagabond.api.SierraApiService
import com.sierra.vagabond.utils.GC_BASE_ENDPOINT
import com.sierra.vagabond.utils.RC_BASE_ENDPOINT
import com.sierra.vagabond.utils.RIDB_API_KEY
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @AreasAPI
    @Singleton
    @Provides
    fun authInterceptor(): AuthInterceptor = AuthInterceptor(apiKey = RIDB_API_KEY)

    @AreasAPI
    @Singleton
    @Provides
    fun provideOkHttpClient(@AreasAPI authInterceptor: AuthInterceptor) = OkHttpClient.Builder().addInterceptor(authInterceptor).build()

    @AreasAPI
    @Singleton
    @Provides
    fun provideAreasService(@AreasAPI okHttpClient: OkHttpClient,
                            gsonConverterFactory: GsonConverterFactory) = createService(okHttpClient, gsonConverterFactory, RC_BASE_ENDPOINT, AreasApiService::class.java)

    @SierraAPI
    @Singleton
    @Provides
    fun provideSierraService(@SierraAPI okHttpClient: OkHttpClient,
                             gsonConverterFactory: GsonConverterFactory) = createService(okHttpClient, gsonConverterFactory, GC_BASE_ENDPOINT, SierraApiService::class.java)

    @SierraAPI
    @Singleton
    @Provides
    fun provideOkHttpClientForSierra(): OkHttpClient = OkHttpClient()


    private fun createRetrofit(okHttpClient: OkHttpClient,
                               converterFactory: GsonConverterFactory,
                               baseUrl: String) : Retrofit {
        return  Retrofit.Builder()
                .addConverterFactory(converterFactory)
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .build()
    }

    private fun <T> createService(okHttpClient: OkHttpClient,
                                  gsonConverterFactory: GsonConverterFactory,
                                  baseUrl: String,
                                  clazz: Class<T>): T {
        return createRetrofit(okHttpClient, gsonConverterFactory, baseUrl).create(clazz)
    }
}