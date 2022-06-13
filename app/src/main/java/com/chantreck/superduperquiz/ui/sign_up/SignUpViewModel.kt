package com.chantreck.superduperquiz.ui.sign_up

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chantreck.superduperquiz.data.retrofit.OnFailureHandler
import com.chantreck.superduperquiz.domain.SignUpUseCase
import com.chantreck.superduperquiz.ui.AuthUiState
import com.chantreck.superduperquiz.ui.validateNickname
import com.chantreck.superduperquiz.ui.validatePassword

class SignUpViewModel : ViewModel() {
    private val handler = object : OnFailureHandler {
        override fun onFailure(message: String) {
            val state = AuthUiState(false, message)
            _state.value = state
        }
    }
    private val useCase = SignUpUseCase(handler)

    private val _state = MutableLiveData<AuthUiState>()
    val state: LiveData<AuthUiState> get() = _state

    private val _validationState = MutableLiveData<SignUpValidationUiState>()
    val validationState: LiveData<SignUpValidationUiState> get() = _validationState

    fun signUp(nickname: String, password: String, repeatPassword: String) {
        val isNicknameCorrect = nickname.validateNickname()
        val isPasswordCorrect = password.validatePassword()
        val isRepeatPasswordCorrect = password == repeatPassword

        val state = SignUpValidationUiState(
            isNicknameCorrect, isPasswordCorrect, isRepeatPasswordCorrect
        )
        _validationState.value = state

        if (isNicknameCorrect && isPasswordCorrect && isRepeatPasswordCorrect) {
            sendSignUpRequest(nickname, password)
        }
    }

    private fun sendSignUpRequest(nickname: String, password: String) {
        useCase.signUp(nickname, password) {
            val state = AuthUiState(true)
            _state.value = state
        }
    }
}