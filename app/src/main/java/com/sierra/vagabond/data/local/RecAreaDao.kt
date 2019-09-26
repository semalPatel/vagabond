package com.sierra.vagabond.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.utils.DELETE_ALL
import com.sierra.vagabond.utils.SELECT_ALL
import com.sierra.vagabond.utils.SELECT_ONE
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
abstract class RecAreaDao {

    @get:Query(SELECT_ALL)
    abstract val areas: List<RecreationalArea>

    @Insert(onConflict = REPLACE)
    abstract fun save(recreationalArea: RecreationalArea): Completable

    @Insert(onConflict = REPLACE)
    abstract fun saveAll(recreationalAreaList: List<RecreationalArea>)

    @Query(SELECT_ONE)
    protected abstract fun getArea(rec_area_id: String): Flowable<RecreationalArea>

    fun getAreaDistinct(rec_area_id: String)
            : Flowable<RecreationalArea> = getArea(rec_area_id).distinctUntilChanged()

    @Query(DELETE_ALL)
    abstract fun deleteAll()

}