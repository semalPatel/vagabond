package com.sierra.vagabond.api

import com.sierra.vagabond.data.entities.TokenRequest
import com.sierra.vagabond.data.entities.WatchRequest
import com.sierra.vagabond.utils.*
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface SierraApiService {

    @Headers(CONTENT_TYPE)
    @POST(CREATE_WATCH)
    suspend fun createWatch(@Body watch: WatchRequest): WatchRequest

    @Headers(CONTENT_TYPE)
    @POST(DELETE_WATCH)
    fun deleteWatch(
            @Query("query") query: String,
            @Query("full") full: Boolean): Single<WatchRequest>

    @Headers(CONTENT_TYPE)
    @POST(GET_WATCHES)
    fun getWatches(
            @Query("query") query: String,
            @Query("full") full: Boolean): Single<List<WatchRequest>>

    @Headers(CONTENT_TYPE)
    @POST(REGISTER_TOKEN)
    suspend fun registerToken(@Body tokenRequest: TokenRequest): TokenRequest

}