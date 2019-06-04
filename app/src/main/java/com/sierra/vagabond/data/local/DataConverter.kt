package com.sierra.vagabond.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sierra.vagabond.data.entities.RecAreaFacilities
import com.sierra.vagabond.data.entities.RecAreaMedia

class DataConverter {

    @TypeConverter
    fun toRecreationalAreaMedia(json: String?): List<RecAreaMedia>? {
        if (json == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<RecAreaMedia>>() {}.type
        return gson.fromJson<List<RecAreaMedia>>(json, type)
    }

    @TypeConverter
    fun fromRecreationalAreaMedia(recAreaMediaList: List<RecAreaMedia>?): String? {
        if (recAreaMediaList == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<RecAreaMedia>>() {}.type
        return gson.toJson(recAreaMediaList, type)
    }

    @TypeConverter
    fun toRecreationalAreaFacilities(json: String?): List<RecAreaFacilities>? {
        if (json == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<RecAreaFacilities>>() {}.type
        return gson.fromJson<List<RecAreaFacilities>>(json, type)
    }

    @TypeConverter
    fun fromRecreationalFacilities(recAreaFacilities: List<RecAreaFacilities>?): String? {
        if (recAreaFacilities == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<RecAreaFacilities>>() {}.type
        return gson.toJson(recAreaFacilities, type)
    }
}
