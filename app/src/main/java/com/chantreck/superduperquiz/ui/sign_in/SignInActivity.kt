package com.chantreck.superduperquiz.ui.sign_in

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.chantreck.superduperquiz.R
import com.chantreck.superduperquiz.databinding.ActivitySignInBinding
import com.chantreck.superduperquiz.ui.clearStack
import com.chantreck.superduperquiz.ui.hideError
import com.chantreck.superduperquiz.ui.showError
import com.chantreck.superduperquiz.ui.hub.HubActivity

class SignInActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySignInBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<SignInViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setViews()
        setObservers()
    }

    private fun setViews() {
        with(binding.signInToolbar.toolbar) {
            setTitle(R.string.toolbar_sign_in)
            setNavigationOnClickListener {
                finish()
            }
        }

        with(binding.nickname) {
            label.setText(R.string.label_nickname)
            editText.setHint(R.string.hint_nickname)
        }

        with(binding.password) {
            label.setText(R.string.label_password)
            editText.setHint(R.string.hint_password)
            editText.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
        }

        binding.signInButton.setOnClickListener {
            val nickname = binding.nickname.editText.text.toString().trim()
            val password = binding.password.editText.text.toString().trim()

            viewModel.signIn(nickname, password)
        }
    }

    private fun setObservers() {
        viewModel.validationState.observe(this) { state ->
            if (state.isNicknameCorrect) {
                binding.nickname.layout.hideError()
            } else {
                binding.nickname.layout.showError(R.string.error_nickname)
            }

            if (state.isPasswordCorrect) {
                binding.password.layout.hideError()
            } else {
                binding.password.layout.showError(R.string.error_password)
            }
        }

        viewModel.isSignInSuccessful.observe(this) {
            val intent = Intent(this, HubActivity::class.java)
            intent.clearStack()
            startActivity(intent)
        }
    }
}