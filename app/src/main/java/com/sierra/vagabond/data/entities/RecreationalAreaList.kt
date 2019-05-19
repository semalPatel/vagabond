package com.sierra.vagabond.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RecreationalAreaList(@field:SerializedName(AREAS_DATA) @field:Expose val recreationalAreaList: List<RecreationalArea>) {

    companion object {
        private const val AREAS_DATA = "RECDATA"
    }
}
