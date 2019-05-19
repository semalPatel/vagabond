package com.sierra.vagabond.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class RecreationalArea(
        @field:PrimaryKey @field:SerializedName(REC_AREA_ID) @field:Expose val recAreaID: String,
        @field:SerializedName(REC_AREA_NAME) @field:Expose val recAreaName: String,
        @field:SerializedName(REC_AREA_DESC) @field:Expose val recAreaDescription: String,
        @field:SerializedName(REC_AREA_DIRS) @field:Expose val recAreaDirections: String,
        @field:SerializedName(REC_AREA_PHONE) @field:Expose val recAreaPhone: String,
        @field:SerializedName(REC_AREA_EMAIL) @field:Expose val recAreaEmail: String,
        @field:SerializedName(REC_AREA_MEDIA) @field:Expose @field:TypeConverters(DataConverter::class) val recAreaMediaList: List<RecAreaMedia>) {

        companion object {
                private const val REC_AREA_ID = "RecAreaID"
                private const val REC_AREA_NAME = "RecAreaName"
                private const val REC_AREA_DESC = "RecAreaDescription"
                private const val REC_AREA_DIRS = "RecAreaDirections"
                private const val REC_AREA_PHONE = "RecAreaPhone"
                private const val REC_AREA_EMAIL = "RecAreaEmail"
                private const val REC_AREA_MEDIA = "MEDIA"
        }
}
