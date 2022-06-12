package com.chantreck.superduperquiz

import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.showError(error: Int) {
    this.error = this.context.getString(error)
}

fun TextInputLayout.hideError() {
    this.error = null
    this.isErrorEnabled = false
}