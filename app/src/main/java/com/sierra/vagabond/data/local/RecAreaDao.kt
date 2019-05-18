package com.sierra.vagabond.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.sierra.vagabond.data.entities.RecreationalArea

@Dao
interface RecAreaDao {

    @get:Query("SELECT * FROM recreationalarea")
    val areas: List<RecreationalArea>

    @Insert(onConflict = REPLACE)
    fun save(recreationalAreaList: List<RecreationalArea>)

    @Query("SELECT * FROM recreationalarea WHERE recAreaID = :rec_area_id")
    fun getArea(rec_area_id: String): RecreationalArea
}
