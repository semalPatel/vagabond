package com.sierra.vagabond.data.entities

import com.google.gson.annotations.SerializedName

data class TokenResponse(@SerializedName(REGISTRATION_TOKEN) val registrationToken: String){

    companion object {
        private const val REGISTRATION_TOKEN = "registration_token"
    }
}