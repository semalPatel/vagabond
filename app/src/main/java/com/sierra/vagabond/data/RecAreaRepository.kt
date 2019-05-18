package com.sierra.vagabond.data

import android.content.Context
import android.os.AsyncTask

import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.data.local.RecAreaDao
import com.sierra.vagabond.data.local.RecAreaDatabase

class RecAreaRepository(context: Context) {

    private val recAreaDao: RecAreaDao
    val areas: List<RecreationalArea>
    private val singleArea: RecreationalArea? = null

    init {
        val db = RecAreaDatabase.getInstance(context)
        recAreaDao = db!!.recAreaDao()
        areas = recAreaDao.areas
    }

    fun getSingleArea(recAreaId: String): RecreationalArea {
        return recAreaDao.getArea(recAreaId)
    }

    fun saveAreas(recreationalAreas: List<RecreationalArea>) {
        asyncInsertTask(recAreaDao).execute(recreationalAreas)
    }

    private class asyncInsertTask internal constructor(private val mRecAreaDao: RecAreaDao) : AsyncTask<List<RecreationalArea>, Void, Void>() {

        override fun doInBackground(vararg lists: List<RecreationalArea>): Void? {
            mRecAreaDao.save(lists[0])
            return null
        }
    }
}
