package com.sierra.vagabond.data.remote

import com.sierra.vagabond.data.entities.RecreationalAreaList
import com.sierra.vagabond.utils.*
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface AreasApiService {

    @GET(RC_AREAS_ENDPOINT)
    fun getRecreationalAreaData(@Query(QUERY) query: String,
                                @Query(FULL) full: Boolean,
                                @Query(ACTIVITY) activity: String,
                                @Header(API_KEY) apiKey: String): Observable<RecreationalAreaList>

    companion object Factory {

        fun create(): AreasApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(RC_BASE_ENDPOINT)
                    .build()
            return retrofit.create(AreasApiService::class.java)
        }
    }
}




