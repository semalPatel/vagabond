package com.sierra.vagabond.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sierra.vagabond.utils.FCM_TOKEN
import com.sierra.vagabond.utils.USER_WATCH_ID

data class TokenRequest(@field:SerializedName(USER_WATCH_ID) @field:Expose val userId: String?,
                        @field:SerializedName(FCM_TOKEN) @field:Expose val fcmToken: String?)