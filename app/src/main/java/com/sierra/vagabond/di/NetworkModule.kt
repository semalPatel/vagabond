package com.sierra.vagabond.di

import com.sierra.vagabond.api.AreasApiService
import com.sierra.vagabond.api.AuthInterceptor
import com.sierra.vagabond.api.SierraApiService
import com.sierra.vagabond.utils.GC_BASE_ENDPOINT
import com.sierra.vagabond.utils.RC_BASE_ENDPOINT
import com.sierra.vagabond.utils.RIDB_API_KEY
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient()

    @AreasAPI
    @Provides
    fun provideOkHttpClientForAreas(upstreamClient: OkHttpClient): OkHttpClient =
            upstreamClient.newBuilder().addInterceptor(AuthInterceptor(apiKey = RIDB_API_KEY)).build()

    @Singleton
    @Provides
    fun provideAreasService(@AreasAPI okHttpClient: OkHttpClient,
                            gsonConverterFactory: GsonConverterFactory) = createService(okHttpClient, gsonConverterFactory, RC_BASE_ENDPOINT, AreasApiService::class.java)

    @Provides
    fun provideSierraService(@SierraAPI okHttpClient: OkHttpClient,
                             gsonConverterFactory: GsonConverterFactory) = createService(okHttpClient, gsonConverterFactory, GC_BASE_ENDPOINT, SierraApiService::class.java)

    @SierraAPI
    @Provides
    fun provideOkHttpClientForSierra(upstreamClient: OkHttpClient): OkHttpClient =
            upstreamClient.newBuilder().build()


    private fun createRetrofit(okHttpClient: OkHttpClient,
                               converterFactory: GsonConverterFactory,
                               baseUrl: String) : Retrofit {
        return  Retrofit.Builder()
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
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