package com.chantreck.superduperquiz.data.auth

import com.chantreck.superduperquiz.data.retrofit.Network
import com.chantreck.superduperquiz.data.retrofit.OnFailureHandler
import com.chantreck.superduperquiz.data.auth.dto.AuthBody
import com.chantreck.superduperquiz.data.auth.dto.AuthResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthController(private val handler: OnFailureHandler) {
    private val api: AuthInterface = Network.retrofit.create(AuthInterface::class.java)
    private val authorizedApi: AuthInterface =
        Network.authorizedRetrofit.create(AuthInterface::class.java)

    fun register(body: AuthBody, onSuccess: (response: AuthResponse) -> Unit) {
        api.register(body).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let { onSuccess.invoke(it) }
                } else {
                    onFailure(response)
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                onFailure(t)
            }
        })
    }

    fun login(body: AuthBody, onSuccess: (response: AuthResponse) -> Unit) {
        api.login(body).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let { onSuccess.invoke(it) }
                } else {
                    onFailure(response)
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                onFailure(t)
            }
        })
    }

    private fun <T> onFailure(response: Response<T>) {
        val errorBody = response.code().toString()
        handler.onFailure("Ошибка $errorBody")
    }

    private fun onFailure(t: Throwable) {
        val message = t.message ?: return
        handler.onFailure(message)
    }
}