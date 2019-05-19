package com.sierra.vagabond.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RecAreaMedia(@field:SerializedName(IMG_TITLE) @field:Expose val imageTitle: String,
                        @field:SerializedName(IMG_HEIGHT) @field:Expose val imageHeight: Int,
                        @field:SerializedName(IMG_WIDTH) @field:Expose val imageWidth: Int,
                        @field:SerializedName(IMG_URL) @field:Expose val imageURL: String) {

    companion object {
        private const val IMG_TITLE = "Title"
        private const val IMG_HEIGHT = "Height"
        private const val IMG_WIDTH = "Width"
        private const val IMG_URL = "URL"
    }
}
