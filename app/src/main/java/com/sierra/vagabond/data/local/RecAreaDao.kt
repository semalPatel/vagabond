package com.sierra.vagabond.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.utils.DELETE_ALL
import com.sierra.vagabond.utils.SELECT_ALL
import com.sierra.vagabond.utils.SELECT_ONE

@Dao
abstract class RecAreaDao {

    @get:Query(SELECT_ALL)
    abstract val areas: List<RecreationalArea>

    @Insert(onConflict = REPLACE)
    abstract suspend fun save(recreationalArea: RecreationalArea)

    @Insert(onConflict = REPLACE)
    abstract suspend fun saveAll(recreationalAreaList: List<RecreationalArea>)

    @Query(SELECT_ONE)
    abstract suspend fun getArea(rec_area_id: String?): RecreationalArea

    @Query(DELETE_ALL)
    abstract fun deleteAll()
}