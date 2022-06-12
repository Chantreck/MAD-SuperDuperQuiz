package com.chantreck.superduperquiz.ui.sign_in

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chantreck.superduperquiz.ui.validateNickname
import com.chantreck.superduperquiz.ui.validatePassword

class SignInViewModel : ViewModel() {
    private val _validationState = MutableLiveData<SignInValidationUiState>()
    val validationState: LiveData<SignInValidationUiState> get() = _validationState

    private val _isSignedIn = MutableLiveData<Boolean>()
    val isSignInSuccessful: LiveData<Boolean> get() = _isSignedIn

    fun signIn(nickname: String, password: String) {
        val isNicknameCorrect = nickname.validateNickname()
        val isPasswordCorrect = password.validatePassword()

        val state = SignInValidationUiState(isNicknameCorrect, isPasswordCorrect)
        _validationState.value = state

        if (isNicknameCorrect && isPasswordCorrect) {
            _isSignedIn.value = true
        }
    }
}