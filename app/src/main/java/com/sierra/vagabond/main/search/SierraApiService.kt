package com.sierra.vagabond.main.search

import com.sierra.vagabond.data.entities.Watch
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface SierraApiService {

    companion object {
        private const val CREATE_WATCH = "create_watch"
        private const val DELETE_WATCH = "delete_watch"
        private const val GET_WATCHES = "get_watches"
        private const val REGISTER_PUSH = "register_push"
        private const val BASE_ENDPOINT = "https://ridb.recreation.gov/api/v1/"

        fun create(): SierraApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_ENDPOINT)
                    .build()
            return retrofit.create(SierraApiService::class.java)
        }
    }

    @POST(CREATE_WATCH)
    fun createWatch(
            @Query("query") query: String,
            @Query("full") full: Boolean,
            @Header("apikey") apiKey: String): Single<Watch>

    @POST(DELETE_WATCH)
    fun deleteWatch(
            @Query("query") query: String,
            @Query("full") full: Boolean,
            @Header("apikey") apiKey: String): Single<Watch>

    @POST(GET_WATCHES)
    fun getWatches(
            @Query("query") query: String,
            @Query("full") full: Boolean,
            @Header("apikey") apiKey: String): Single<Watch>

    @POST(REGISTER_PUSH)
    fun registerPushToken(
            @Query("query") query: String,
            @Query("full") full: Boolean,
            @Header("apikey") apiKey: String): Single<Watch>

}