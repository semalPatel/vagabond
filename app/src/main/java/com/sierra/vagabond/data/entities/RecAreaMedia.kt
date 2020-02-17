package com.sierra.vagabond.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sierra.vagabond.utils.IMG_HEIGHT
import com.sierra.vagabond.utils.IMG_TITLE
import com.sierra.vagabond.utils.IMG_URL
import com.sierra.vagabond.utils.IMG_WIDTH

data class RecAreaMedia(@field:SerializedName(IMG_TITLE) @field:Expose val imageTitle: String,
                        @field:SerializedName(IMG_HEIGHT) @field:Expose val imageHeight: Int,
                        @field:SerializedName(IMG_WIDTH) @field:Expose val imageWidth: Int,
                        @field:SerializedName(IMG_URL) @field:Expose val imageURL: String)
