package com.sierra.vagabond

import android.app.Application
import android.widget.Toast
import com.google.firebase.iid.FirebaseInstanceId

class VagabondApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseInstanceId.getInstance().instanceId
                .addOnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        Toast.makeText(this@VagabondApplication, task.exception?.message, Toast.LENGTH_SHORT).show()
                    }

                    val token = task.result?.token

                    Toast.makeText(this@VagabondApplication, token, Toast.LENGTH_SHORT).show()
                }
    }
}