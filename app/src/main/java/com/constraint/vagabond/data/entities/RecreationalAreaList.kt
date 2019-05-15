package com.constraint.vagabond.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RecreationalAreaList(@field:SerializedName("RECDATA")
                           @field:Expose
                           var recreationalAreaList: List<RecreationalArea>) {

    override fun toString(): String {
        return "areas: $recreationalAreaList"
    }
}
