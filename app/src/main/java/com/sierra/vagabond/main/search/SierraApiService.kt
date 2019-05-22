package com.sierra.vagabond.main.search

import com.sierra.vagabond.data.entities.PushToken
import com.sierra.vagabond.data.entities.TokenResponse
import com.sierra.vagabond.data.entities.Watch
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface SierraApiService {

    companion object {
        private const val CREATE_WATCH = "create_watch"
        private const val DELETE_WATCH = "delete_watch"
        private const val GET_WATCHES = "get_watches"
        private const val REGISTER_PUSH = "register_push"
        private const val BASE_ENDPOINT = "https://us-central1-sierra-236907.cloudfunctions.net/"


        fun create(): SierraApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_ENDPOINT)
                    .build()
            return retrofit.create(SierraApiService::class.java)
        }
    }

    @POST(REGISTER_PUSH)
    fun registerPushToken(@Body deviceToken: PushToken): Call<TokenResponse>

    @Headers(
        "Accept: application/json",
        "Content-type: application/json")
    @POST(CREATE_WATCH)
    fun createWatch(@Body watch: Watch): Single<Watch>

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

}