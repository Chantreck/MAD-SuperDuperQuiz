package com.chantreck.superduperquiz.ui

import android.content.Intent
import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.showError(error: Int) {
    this.error = this.context.getString(error)
}

fun TextInputLayout.hideError() {
    this.error = null
    this.isErrorEnabled = false
}

fun String.validateNickname() = this.isNotEmpty()

fun String.validatePassword() = this.length >= 6

fun Intent.clearStack() {
    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
}