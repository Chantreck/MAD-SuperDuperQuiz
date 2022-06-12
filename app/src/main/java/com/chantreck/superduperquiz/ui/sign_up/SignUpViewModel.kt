package com.chantreck.superduperquiz.ui.sign_up

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chantreck.superduperquiz.data.SharedPreferences
import com.chantreck.superduperquiz.data.auth.UserInfo
import com.chantreck.superduperquiz.validateNickname
import com.chantreck.superduperquiz.validatePassword

class SignUpViewModel : ViewModel() {
    private val _validationState = MutableLiveData<SignUpValidationUiState>()
    val validationState: LiveData<SignUpValidationUiState> get() = _validationState

    private val _isSignUpSuccessful = MutableLiveData<Boolean>()
    val isSignUpSuccessful: LiveData<Boolean> get() = _isSignUpSuccessful

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
        //TODO отправка запроса на сервер

        val userInfo = UserInfo(nickname, password)
        SharedPreferences.saveUserInfo(userInfo)

        _isSignUpSuccessful.value = true
    }
}