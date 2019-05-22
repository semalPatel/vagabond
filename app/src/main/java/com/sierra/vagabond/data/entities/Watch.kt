package com.sierra.vagabond.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Watch (

        @field:SerializedName(FACILITY_ID) @field:Expose val facilityId: String,
        @field:SerializedName(FACILITY_NAME) @field:Expose val facilityName: String,
        @field:SerializedName(START_DATE) @field:Expose val startDate: Long,
        @field:SerializedName(WATCH_TOKEN) @field:Expose val watchToken: String?
//        @field:SerializedName(WATCH_ID) @field:Expose val watchId: String?
) {

    companion object {
        private const val FACILITY_ID = "facility_id"
        private const val FACILITY_NAME = "facility_name"
        private const val START_DATE = "start_date"
        private const val WATCH_TOKEN = "token"
//        private const val WATCH_ID = "watch_id"
    }
}