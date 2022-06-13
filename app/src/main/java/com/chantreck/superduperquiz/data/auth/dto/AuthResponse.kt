package com.chantreck.superduperquiz.data.auth.dto

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    val username: String,
    val token: String
)
