package com.chantreck.superduperquiz.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.chantreck.superduperquiz.data.auth.UserInfo

object SharedPreferences {
    private const val PREFERENCES = "SuperDuperQuiz"
    private const val NICKNAME_KEY = "NICKNAME"
    private const val TOKEN_KEY = "TOKEN"
    const val EMPTY_RESULT = ""
    private var preferences: SharedPreferences? = null

    fun setup(context: Context) {
        preferences = context.getSharedPreferences(PREFERENCES, MODE_PRIVATE)
    }

    fun saveUserInfo(userInfo: UserInfo) {
        val instance = preferences ?: return
        with (instance.edit()) {
            putString(NICKNAME_KEY, userInfo.nickname)
            putString(TOKEN_KEY, userInfo.token)
            apply()
        }
    }

    fun clearUserInfo() {
        val instance = preferences ?: return
        instance.edit()
            .clear()
            .apply()
    }

    fun getNickname(): String {
        val instance = preferences ?: return EMPTY_RESULT
        return instance.getString(NICKNAME_KEY, EMPTY_RESULT) ?: EMPTY_RESULT
    }

    fun getToken(): String {
        val instance = preferences ?: return EMPTY_RESULT
        return instance.getString(TOKEN_KEY, EMPTY_RESULT) ?: EMPTY_RESULT
    }
}