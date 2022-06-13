package com.chantreck.superduperquiz.data.auth

import com.chantreck.superduperquiz.data.auth.dto.AuthBody
import com.chantreck.superduperquiz.data.auth.dto.AuthResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthInterface {
    @POST("auth/register")
    fun register(@Body body: AuthBody): Call<AuthResponse>

    @POST("auth/login")
    fun login(@Body body: AuthBody): Call<AuthResponse>

    @POST("auth/logout")
    fun logout(): Call<Void>
}