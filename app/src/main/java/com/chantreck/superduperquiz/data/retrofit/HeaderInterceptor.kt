package com.chantreck.superduperquiz.data.retrofit

import com.chantreck.superduperquiz.data.SharedPreferences
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
            .header("Authorization", "Bearer " + SharedPreferences.getToken())
            .build()
        return chain.proceed(newRequest)
    }
}