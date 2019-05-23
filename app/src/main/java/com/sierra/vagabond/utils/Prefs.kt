package com.sierra.vagabond.utils

import android.content.Context
import android.content.SharedPreferences

object Prefs {

    private lateinit var deviceInfo: SharedPreferences
    private val DEVICE_REGISTRATION_TOKEN = Pair("deviceRegistrationToken", "")

    fun init(context: Context){
        deviceInfo = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = this.edit()
        operation(editor)
        editor.apply()
    }

    var deviceRegistrationToken: String
        get() = deviceInfo.getString(DEVICE_REGISTRATION_TOKEN.first, DEVICE_REGISTRATION_TOKEN.second)!!
        set(value) = deviceInfo.edit{
            it.putString(DEVICE_REGISTRATION_TOKEN.first, value)
        }
}