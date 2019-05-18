package com.sierra.vagabond.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class RecreationalArea(
        @field:PrimaryKey
        @field:SerializedName("RecAreaID")
        @field:Expose
        val recAreaID: String,
        @field:SerializedName("RecAreaName")
        @field:Expose
        val recAreaName: String,
        @field:SerializedName("RecAreaDescription")
        @field:Expose
        val recAreaDescription: String,
        @field:SerializedName("RecAreaDirections")
        @field:Expose
        val recAreaDirections: String,
        @field:SerializedName("RecAreaPhone")
        @field:Expose
        val recAreaPhone: String,
        @field:SerializedName("RecAreaEmail")
        @field:Expose
        val recAreaEmail: String,
        @field:SerializedName("MEDIA")
        @field:Expose
        @field:TypeConverters(DataConverter::class)
        val recAreaMediaList: List<RecAreaMedia>)
