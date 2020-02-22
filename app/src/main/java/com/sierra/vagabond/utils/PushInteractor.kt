package com.sierra.vagabond.utils

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PushInteractor {

    suspend fun registerDeviceToken() {
        withContext(Dispatchers.Default) {
            registerTokenInternal()
        }
    }

    private fun registerTokenInternal() {
        FirebaseInstanceId.getInstance().getToken("463740532540", "FCM").also { token ->
            Prefs.deviceRegistrationToken = token!!
        }
    }
}