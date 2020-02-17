package com.sierra.vagabond.utils

import android.annotation.SuppressLint
import com.google.firebase.iid.FirebaseInstanceId
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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