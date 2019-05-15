package com.constraint.vagabond.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RecAreaMedia(@field:SerializedName("Title")
                   @field:Expose
                   val imageTitle: String, @field:SerializedName("Height")
                   @field:Expose
                   val imageHeight: Int?, @field:SerializedName("Width")
                   @field:Expose
                   val imageWidth: Int?, @field:SerializedName("URL")
                   @field:Expose
                   val imageURL: String) {

    override fun toString(): String {

        return ("image_url: "
                + imageURL
                + "\n"
                + "image_title: "
                + imageTitle
                + "\n"
                + "image_height: "
                + imageHeight
                + "\n"
                + "image_width: "
                + imageWidth)
    }
}
