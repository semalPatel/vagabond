package com.sierra.vagabond.utils

import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PushInteractor {

    fun registerDeviceToken() {
        CoroutineScope(Dispatchers.Default).launch {
            registerTokenInternal()
        }
    }

    private fun registerTokenInternal() {
        FirebaseInstanceId.getInstance().getToken("463740532540", "FCM").also { token ->
            Prefs.deviceRegistrationToken = token!!
        }
    }
}