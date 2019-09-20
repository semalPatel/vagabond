package com.sierra.vagabond.data

import android.content.Context
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.data.local.RecAreaDao
import com.sierra.vagabond.data.local.RecAreaDatabase
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers


class RecAreaRepository(context: Context) {

    private val recAreaDao: RecAreaDao

    init {
        val db = RecAreaDatabase.getInstance(context)
        recAreaDao = db.recAreaDao()
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
