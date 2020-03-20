package com.sierra.vagabond.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sierra.vagabond.data.entities.RecAreaFacilities
import com.sierra.vagabond.data.entities.RecAreaMedia

class DataConverter {

    private val gson = Gson()

    @TypeConverter
    fun toRecreationalAreaMedia(json: String?): List<RecAreaMedia>? {
        if (json == null) {
            return null
        }
        val type = object : TypeToken<List<RecAreaMedia>>() {}.type
        return gson.fromJson<List<RecAreaMedia>>(json, type)
    }

    @TypeConverter
    fun fromRecreationalAreaMedia(recAreaMediaList: List<RecAreaMedia>?): String? {
        if (recAreaMediaList == null) {
            return null
        }
        val type = object : TypeToken<List<RecAreaMedia>>() {}.type
        return gson.toJson(recAreaMediaList, type)
    }
}
