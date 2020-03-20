package com.sierra.vagabond.api

import com.sierra.vagabond.data.entities.RecAreaFacilities
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.data.entities.Wrapper
import com.sierra.vagabond.utils.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AreasApiService {

    @GET(RC_AREAS_ENDPOINT)
    suspend fun getRecreationalAreaData(@Query(QUERY) query: String,
                                @Query(FULL) full: Boolean,
                                @Query(ACTIVITY) activity: String,
                                @Query (SORT) by: String): Wrapper<RecreationalArea>
    @GET(RC_FACILITIES_ENDPOINT)
    suspend fun getFacilitiesForArea(@Path(REC_AREA_ID) recAreaId: String?,
                                     @Query(FULL) full: Boolean,
                                     @Query(ACTIVITY) activity: String): Wrapper<RecAreaFacilities>

}




