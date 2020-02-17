package com.sierra.vagabond.api

import com.sierra.vagabond.data.entities.WatchRequest
import com.sierra.vagabond.data.entities.WatchResponse
import com.sierra.vagabond.utils.*
import io.reactivex.Single
import retrofit2.http.*

interface SierraApiService {

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