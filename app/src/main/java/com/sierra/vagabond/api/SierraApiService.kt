package com.sierra.vagabond.api

import com.sierra.vagabond.data.entities.WatchRequest
import com.sierra.vagabond.data.entities.WatchResponse
import com.sierra.vagabond.utils.*
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface SierraApiService {

    /*companion object {

        fun create(): SierraApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(GC_BASE_ENDPOINT)
                    .build()
            return retrofit.create(SierraApiService::class.java)
        }
    }*/

    @Headers(ACCEPT_HEADER,
            CONTENT_TYPE)
    @POST(CREATE_WATCH)
    fun createWatch(@Body watch: WatchRequest): Single<WatchResponse>

    @POST(DELETE_WATCH)
    fun deleteWatch(
            @Query("query") query: String,
            @Query("full") full: Boolean,
            @Header("apikey") apiKey: String): Single<WatchResponse>

    @POST(GET_WATCHES)
    fun getWatches(
            @Query("query") query: String,
            @Query("full") full: Boolean,
            @Header("apikey") apiKey: String): Single<WatchResponse>

}