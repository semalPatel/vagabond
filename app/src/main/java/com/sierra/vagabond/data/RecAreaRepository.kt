package com.sierra.vagabond.data

import android.content.Context
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.data.local.RecAreaDao
import com.sierra.vagabond.data.local.RecAreaDatabase
import io.reactivex.Single


class RecAreaRepository(context: Context) {

    private val recAreaDao: RecAreaDao

    init {
        val db = RecAreaDatabase.getInstance(context)
        recAreaDao = db.recAreaDao()
    }


    fun getSingleArea(recAreaId: String): Single<RecreationalArea> {
        return recAreaDao.getArea(recAreaId)
    }

    fun insert(recreationalArea: RecreationalArea) {
        recAreaDao.save(recreationalArea)
    }
}
