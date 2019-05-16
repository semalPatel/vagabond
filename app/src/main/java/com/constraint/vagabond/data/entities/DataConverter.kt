package com.constraint.vagabond.data.entities

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DataConverter {

    @TypeConverter
    fun fromRecreationalAreaMedia(recAreaMediaList: List<RecAreaMedia>?): String? {
        if (recAreaMediaList == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<RecAreaMedia>>() {

        }.type
        return gson.toJson(recAreaMediaList, type)
    }

    @TypeConverter
    fun toRecreationalAreaMedia(json: String?): List<RecAreaMedia>? {
        if (json == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<RecAreaMedia>>() {

        }.type
        return gson.fromJson<List<RecAreaMedia>>(json, type)
    }
}
