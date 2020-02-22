package com.sierra.vagabond.data

import com.sierra.vagabond.api.AreasApiService
import com.sierra.vagabond.api.SierraApiService
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.data.entities.TokenRequest
import com.sierra.vagabond.data.entities.WatchRequest
import com.sierra.vagabond.data.local.RecAreaDao
import com.sierra.vagabond.di.AreasAPI
import com.sierra.vagabond.di.SierraAPI
import com.sierra.vagabond.utils.BY_NAME
import com.sierra.vagabond.utils.CAMPING
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RecAreaRepository @Inject constructor(private val recAreaDao: RecAreaDao, @AreasAPI private val service: AreasApiService, @SierraAPI private val sierraAPI: SierraApiService) {

    suspend fun getRecAreasList(query: String): List<RecreationalArea> {
        return service.getRecreationalAreaData(query = query, full = true, activity = CAMPING, by = BY_NAME).areasList
    }

    suspend fun getSingleArea(recAreaId: String): RecreationalArea {
        return recAreaDao.getArea(recAreaId)
    }

    suspend fun createWatch(watch: WatchRequest) {
        sierraAPI.createWatch(watch)
    }

    suspend fun insert(recreationalArea: RecreationalArea) {
        recAreaDao.save(recreationalArea)
    }

    suspend fun clearAll() {
        recAreaDao.deleteAll()
    }

    suspend fun registerToken(tokenRequest: TokenRequest) {
        sierraAPI.registerToken(tokenRequest)
    }
}
