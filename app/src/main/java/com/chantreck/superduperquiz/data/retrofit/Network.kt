package com.chantreck.superduperquiz.data.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object Network {
    private const val BASE_URL = "http://10.0.2.2:8191/"
    private val mediaType = "application/json".toMediaType()

    private val authorizedClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .addInterceptor(HeaderInterceptor())
        .build()

    private val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    @OptIn(ExperimentalSerializationApi::class)
    val authorizedRetrofit: Retrofit = Retrofit.Builder()
        .client(authorizedClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(Json.asConverterFactory(mediaType))
        .build()

    @OptIn(ExperimentalSerializationApi::class)
    val retrofit: Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BASE_URL)
        .addConverterFactory(Json.asConverterFactory(mediaType))
        .build()
}