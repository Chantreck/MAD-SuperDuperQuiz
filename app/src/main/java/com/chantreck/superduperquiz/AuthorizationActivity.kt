package com.chantreck.superduperquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AuthorizationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_SuperDuperQuiz)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)
    }
}