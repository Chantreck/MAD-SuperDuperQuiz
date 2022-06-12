package com.chantreck.superduperquiz.ui.sign_in

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignInViewModel : ViewModel() {
    private val _validationState = MutableLiveData<SignInValidationUiState>()
    val validationState: LiveData<SignInValidationUiState> get() = _validationState

    private val _isSignedIn = MutableLiveData<Boolean>()
    val isSignedIn: LiveData<Boolean> get() = _isSignedIn

    fun signIn(nickname: String, password: String) {
        val isNicknameCorrect = validateNickname(nickname)
        val isPasswordCorrect = validatePassword(password)

        val state = SignInValidationUiState(isNicknameCorrect, isPasswordCorrect)

        _validationState.value = state

        if (isNicknameCorrect && isPasswordCorrect) {
            _isSignedIn.value = true
        }
    }

    private fun validateNickname(nickname: String) = nickname.isNotEmpty()

    private fun validatePassword(password: String) = password.length >= 6
}