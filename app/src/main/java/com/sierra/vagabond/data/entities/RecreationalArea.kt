package com.sierra.vagabond.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sierra.vagabond.data.local.DataConverter
import com.sierra.vagabond.utils.*
import kotlinx.android.parcel.Parcelize

@Entity(tableName = TABLE_NAME)
@Parcelize
data class RecreationalArea(@field:PrimaryKey @field:SerializedName(REC_AREA_ID) @field:Expose val recAreaID: String,
                            @field:SerializedName(REC_AREA_NAME) @field:Expose val recAreaName: String,
                            @field:SerializedName(REC_AREA_DESC) @field:Expose val recAreaDescription: String,
                            @field:SerializedName(REC_AREA_DIRS) @field:Expose val recAreaDirections: String,
                            @field:SerializedName(REC_AREA_PHONE) @field:Expose val recAreaPhone: String,
                            @field:SerializedName(REC_AREA_EMAIL) @field:Expose val recAreaEmail: String,
                            @field:SerializedName(REC_AREA_MEDIA) @field:Expose @field:TypeConverters(DataConverter::class) val recAreaMediaList: List<RecAreaMedia>,
                            @field:SerializedName(REC_AREA_FACILITIES) @field:Expose @field:TypeConverters(DataConverter::class) val recAreaFacilities: List<RecAreaFacilities>) : Parcelable
