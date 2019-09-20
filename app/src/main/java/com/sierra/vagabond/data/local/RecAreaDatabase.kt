package com.sierra.vagabond.data.local

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.utils.DB_NAME

@Database(entities = [RecreationalArea::class], version = 1, exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class RecAreaDatabase : RoomDatabase() {

    abstract fun recAreaDao(): RecAreaDao

    fun destroyDB() {
        INSTANCE = null
    }

    companion object {

        @Volatile
        private var INSTANCE: RecAreaDatabase? = null

        fun getInstance(application: Context): RecAreaDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(application).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        RecAreaDatabase::class.java, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
    }
}

