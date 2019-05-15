package com.constraint.vagabond.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RecAreaMedia(@field:SerializedName("Title")
                   @field:Expose
                   val imageTitle: String, @field:SerializedName("Height")
                   @field:Expose
                   val imageHeight: Int?, @field:SerializedName("Width")
                   @field:Expose
                   val imageWidth: Int?, @field:SerializedName("URL")
                   @field:Expose
                   val imageURL: String)
