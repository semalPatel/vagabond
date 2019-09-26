package com.sierra.vagabond.data

import com.sierra.vagabond.api.AreasApiService
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.data.entities.RecreationalAreaList
import com.sierra.vagabond.data.local.RecAreaDao
import com.sierra.vagabond.utils.CAMPING
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RecAreaRepository @Inject constructor(private val recAreaDao: RecAreaDao, private val service: AreasApiService) {

    fun getRecAreasList(query: String): Observable<RecreationalAreaList> {
        return service.getRecreationalAreaData(query, full = true, activity = CAMPING).also {
            it.map { areaList ->
                recAreaDao.saveAll(areaList.areasList)
            }
        }
    }

    fun getSingleArea(recAreaId: String): Flowable<RecreationalArea> {
        return recAreaDao.getAreaDistinct(recAreaId)
    }

    fun insert(recreationalArea: RecreationalArea) {
        recAreaDao.save(recreationalArea)
                .subscribeOn(Schedulers.io())
                .subscribe()
    }

    fun clearAll() {
        recAreaDao.deleteAll()
    }
}
