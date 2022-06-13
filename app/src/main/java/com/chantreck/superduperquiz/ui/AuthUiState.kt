package com.chantreck.superduperquiz.ui

data class AuthUiState(
    val isSignedIn: Boolean,
    val error: String? = null
)
