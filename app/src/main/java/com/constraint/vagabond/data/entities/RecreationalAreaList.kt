package com.constraint.vagabond.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RecreationalAreaList(@field:SerializedName("RECDATA")
                                @field:Expose
                                val recreationalAreaList: List<RecreationalArea>)
