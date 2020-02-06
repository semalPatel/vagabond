package com.sierra.vagabond.utils

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PushInteractor {

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
        /*Observable.just("")
                .map { FirebaseInstanceId.getInstance().getToken("463740532540", "FCM") }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("Token", it)
                })*/
    }
}