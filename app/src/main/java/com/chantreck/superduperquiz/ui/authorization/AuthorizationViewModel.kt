package com.chantreck.superduperquiz.ui.authorization

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chantreck.superduperquiz.data.SharedPreferences

class AuthorizationViewModel: ViewModel() {
    private val _isSignedIn = MutableLiveData<Boolean>()
    val isSignedIn: LiveData<Boolean> get() = _isSignedIn

    init {
        _isSignedIn.value = SharedPreferences.getToken() != SharedPreferences.EMPTY_RESULT
    }
}