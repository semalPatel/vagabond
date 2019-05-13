package com.constraint.vagabond.main.search

import android.util.Log

import com.constraint.vagabond.data.entities.RecreationalAreaList
import com.constraint.vagabond.network.RetrofitInstance

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetRecAreasImpl : MainContract.GetRecAreasInteractor {

    override fun getRecAreasList(onFinishedListener: MainContract.GetRecAreasInteractor.OnFinishedListener, query: String) {
        val service = RetrofitInstance.create()
        val apiKey = "api-key"
        val call = service.getRecreationalAreaData(query, true, apiKey)
        Log.d("URL called", call.request().url().toString() + "")
        call.enqueue(
                object : Callback<RecreationalAreaList> {
                    override fun onResponse(call: Call<RecreationalAreaList>, response: Response<RecreationalAreaList>) {
                        onFinishedListener.onFinished(response.body())
                    }

                    override fun onFailure(call: Call<RecreationalAreaList>, t: Throwable) {
                        onFinishedListener.onFailure(t)
                    }
                })
    }
}
