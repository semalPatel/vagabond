package com.sierra.vagabond.data.entities

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecAreaFacilities (@field:SerializedName(FACILITY_ID) @field:Expose val facilityId: String,
                              @field:SerializedName(FACILITY_NAME) @field:Expose val facilityName: String) : Parcelable {
    companion object {
        private const val FACILITY_ID = "FacilityID"
        private const val FACILITY_NAME = "FacilityName"
    }
}