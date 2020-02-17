package com.sierra.vagabond.utils

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
                .map { FirebaseInstanceId.getInstance().getToken("", "FCM") }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("Token", it)
                })*/
    }
}