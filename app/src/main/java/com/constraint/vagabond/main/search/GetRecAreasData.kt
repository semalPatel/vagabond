package com.constraint.vagabond.main.search

import com.constraint.vagabond.data.entities.RecreationalAreaList

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GetRecAreasData {

    @GET("recareas")
    fun getRecreationalAreaData(
            @Query("query") query: String, @Query("full") full: Boolean, @Header("apikey") apiKey: String): Call<RecreationalAreaList>
}
