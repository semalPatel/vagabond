package com.sierra.vagabond.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.utils.DELETE_ALL
import com.sierra.vagabond.utils.SELECT_ALL
import com.sierra.vagabond.utils.TABLE_NAME
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface RecAreaDao {

    @get:Query(SELECT_ALL)
    val areas: List<RecreationalArea>

    @Insert(onConflict = REPLACE)
    fun save(recreationalArea: RecreationalArea): Completable

    @Query("SELECT * FROM $TABLE_NAME WHERE recAreaID = :rec_area_id")
    fun getArea(rec_area_id: String): Single<RecreationalArea>

    @Query(DELETE_ALL)
    fun deleteAll()

}
