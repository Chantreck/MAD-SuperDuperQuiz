package com.chantreck.superduperquiz.ui.sign_in

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chantreck.superduperquiz.data.retrofit.OnFailureHandler
import com.chantreck.superduperquiz.domain.SignInUseCase
import com.chantreck.superduperquiz.ui.AuthUiState
import com.chantreck.superduperquiz.ui.validateNickname
import com.chantreck.superduperquiz.ui.validatePassword

class SignInViewModel : ViewModel() {
    private val handler = object : OnFailureHandler {
        override fun onFailure(message: String) {
            val state = AuthUiState(false, message)
            _state.value = state
        }
    }
    private val useCase = SignInUseCase(handler)

    private val _state = MutableLiveData<AuthUiState>()
    val state: LiveData<AuthUiState> get() = _state

    private val _validationState = MutableLiveData<SignInValidationUiState>()
    val validationState: LiveData<SignInValidationUiState> get() = _validationState

    fun signIn(nickname: String, password: String) {
        val isNicknameCorrect = nickname.validateNickname()
        val isPasswordCorrect = password.validatePassword()

        val state = SignInValidationUiState(isNicknameCorrect, isPasswordCorrect)
        _validationState.value = state

        if (isNicknameCorrect && isPasswordCorrect) {
            sendSignInRequest(nickname, password)
        }
    }

    private fun sendSignInRequest(nickname: String, password: String) {
        useCase.signIn(nickname, password) {
            val state = AuthUiState(true)
            _state.value = state
        }
    }
}