package com.chantreck.superduperquiz.data.auth.dto

import kotlinx.serialization.Serializable

@Serializable
data class AuthBody(
    val username: String,
    val password: String
)