package com.constraint.vagabond.network

import com.constraint.vagabond.main.search.GetRecAreasData
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {

    private const val BASE_URL = "https://ridb.recreation.gov/api/v1/"

    fun create(): GetRecAreasData {
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
        return retrofit.create(GetRecAreasData::class.java)
    }

}
