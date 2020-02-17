package com.sierra.vagabond.api

import com.sierra.vagabond.data.entities.RecreationalAreaList
import com.sierra.vagabond.utils.*
import retrofit2.http.GET
import retrofit2.http.Query

interface AreasApiService {

    @GET(RC_AREAS_ENDPOINT)
    suspend fun getRecreationalAreaData(@Query(QUERY) query: String,
                                @Query(FULL) full: Boolean,
                                @Query(ACTIVITY) activity: String,
                                @Query (SORT) by: String): RecreationalAreaList

}




