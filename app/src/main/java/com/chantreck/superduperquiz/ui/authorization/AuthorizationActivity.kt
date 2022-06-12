package com.chantreck.superduperquiz.ui.authorization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.chantreck.superduperquiz.R
import com.chantreck.superduperquiz.ui.sign_in.SignInActivity
import com.chantreck.superduperquiz.databinding.ActivityAuthorizationBinding
import com.chantreck.superduperquiz.ui.hub.HubActivity
import com.chantreck.superduperquiz.ui.sign_up.SignUpActivity

class AuthorizationActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAuthorizationBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<AuthorizationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_SuperDuperQuiz)
        super.onCreate(savedInstanceState)

        viewModel.isSignedIn.observe(this) { isSignedIn ->
            if (isSignedIn) {
                showNextScreen()
            } else {
                initViews()
            }
        }
    }

    private fun initViews() {
        setContentView(binding.root)

        binding.authorizationSignInButton.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        binding.authorizationSignUpButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showNextScreen() {
        val intent = Intent(this, HubActivity::class.java)
        startActivity(intent)
    }
}