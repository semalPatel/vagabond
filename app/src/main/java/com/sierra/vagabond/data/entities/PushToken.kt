package com.sierra.vagabond.data.entities

import com.google.gson.annotations.SerializedName

data class PushToken(@SerializedName("apns_token") val token: String?)