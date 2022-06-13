package com.chantreck.superduperquiz.domain

import com.chantreck.superduperquiz.data.retrofit.OnFailureHandler
import com.chantreck.superduperquiz.data.SharedPreferences
import com.chantreck.superduperquiz.data.auth.AuthController
import com.chantreck.superduperquiz.data.auth.dto.AuthBody

class SignUpUseCase(private val handler: OnFailureHandler) {
    private val controller = AuthController(handler)

    fun signUp(nickname: String, password: String, onSuccess: () -> Unit) {
        try {
            val body = AuthBody(nickname, password)
            controller.register(body) { response ->
                SharedPreferences.saveUserInfo(response)
                onSuccess()
            }
        } catch (e: Exception) {
            val message = e.message ?: return
            handler.onFailure(message)
        }
    }
}