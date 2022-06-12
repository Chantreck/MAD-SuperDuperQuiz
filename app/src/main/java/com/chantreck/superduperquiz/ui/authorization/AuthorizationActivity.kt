package com.chantreck.superduperquiz.ui.authorization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chantreck.superduperquiz.R
import com.chantreck.superduperquiz.ui.sign_in.SignInActivity
import com.chantreck.superduperquiz.databinding.ActivityAuthorizationBinding

class AuthorizationActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAuthorizationBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_SuperDuperQuiz)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.authorizationSignInButton.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}