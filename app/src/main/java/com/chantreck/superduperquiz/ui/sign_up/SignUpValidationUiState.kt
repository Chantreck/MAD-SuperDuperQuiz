package com.chantreck.superduperquiz.ui.sign_up

data class SignUpValidationUiState(
    val isNicknameCorrect: Boolean = true,
    val isPasswordCorrect: Boolean = true,
    val isRepeatPasswordCorrect: Boolean = true,
)
