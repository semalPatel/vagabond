package com.sierra.vagabond.utils

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId

class PushInteractor {

    fun registerDeviceToken() {

        FirebaseInstanceId.getInstance().instanceId
                .addOnCompleteListener { task ->
                    val token = task.result?.token
                    Prefs.deviceRegistrationToken = token!!
                }
                .addOnFailureListener { err ->
                    Log.d(javaClass.simpleName, err.toString())
                }
    }
}