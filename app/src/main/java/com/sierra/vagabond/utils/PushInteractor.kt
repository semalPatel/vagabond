package com.sierra.vagabond.utils

import android.annotation.SuppressLint
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.sierra.vagabond.data.RecAreaRepository
import com.sierra.vagabond.data.entities.TokenRequest
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PushInteractor {

    @SuppressLint("CheckResult")
    fun registerDeviceToken() {

//        FirebaseInstanceId.getInstance().instanceId
//                .addOnCompleteListener { task ->
//                    val token = task.result?.token
//                    Prefs.deviceRegistrationToken = token!!
//                    Log.d("Token", token)
//                }
//                .addOnFailureListener { err ->
//                    Log.d(javaClass.simpleName, err.toString())
//                }
        Observable.just("")
                .map { FirebaseInstanceId.getInstance().getToken("463740532540", "FCM") }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Prefs.deviceRegistrationToken = it!!
                }
    }
}