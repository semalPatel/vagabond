package com.sierra.vagabond.data.local

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

import com.sierra.vagabond.data.entities.DataConverter
import com.sierra.vagabond.data.entities.RecreationalArea

@Database(entities = [RecreationalArea::class], version = 1, exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class RecAreaDatabase : RoomDatabase() {

    abstract fun recAreaDao(): RecAreaDao

    fun destroyDB() {
        INSTANCE = null
    }

    companion object {

        private val sLock = Any()
        private var INSTANCE: RecAreaDatabase? = null

        fun getInstance(context: Context): RecAreaDatabase? {
            synchronized(sLock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, RecAreaDatabase::class.java, "Areas.db")
                            .build()
                }
            }
            return INSTANCE
        }
    }
}
