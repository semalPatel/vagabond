package com.sierra.vagabond.api

import com.sierra.vagabond.utils.API_KEY
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class AuthInterceptor(private val apiKey: String) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().addHeader(API_KEY, apiKey).build()
        return chain.proceed(request)
    }
}