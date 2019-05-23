package com.sierra.vagabond.data.entities

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sierra.vagabond.utils.FACILITY_ID
import com.sierra.vagabond.utils.FACILITY_NAME
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecAreaFacilities(@field:SerializedName(FACILITY_ID) @field:Expose val facilityId: String,
                             @field:SerializedName(FACILITY_NAME) @field:Expose val facilityName: String) : Parcelable