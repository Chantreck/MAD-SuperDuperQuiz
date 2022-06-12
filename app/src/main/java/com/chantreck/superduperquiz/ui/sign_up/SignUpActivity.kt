package com.chantreck.superduperquiz.ui.sign_up

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.chantreck.superduperquiz.R
import com.chantreck.superduperquiz.databinding.ActivitySignUpBinding
import com.chantreck.superduperquiz.ui.clearStack
import com.chantreck.superduperquiz.ui.hideError
import com.chantreck.superduperquiz.ui.hub.HubActivity
import com.chantreck.superduperquiz.ui.showError
import com.chantreck.superduperquiz.ui.sign_in.SignInActivity

class SignUpActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySignUpBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<SignUpViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setViews()
        setObservers()
    }

    private fun setViews() {
        with(binding.signUpToolbar.toolbar) {
            setTitle(R.string.toolbar_sign_up)
            setNavigationOnClickListener {
                finish()
            }
        }

        with(binding.signUpNickname) {
            label.setText(R.string.label_nickname)
            editText.setHint(R.string.hint_nickname)
        }

        with(binding.signUpPassword) {
            label.setText(R.string.label_password)
            editText.setHint(R.string.hint_password)
        }

        with(binding.signUpRepeatPassword) {
            label.setText(R.string.label_repeat_password)
            editText.setHint(R.string.hint_password)
        }

        binding.signUpButton.setOnClickListener {
            val nickname = binding.signUpNickname.editText.text.toString().trim()
            val password = binding.signUpPassword.editText.text.toString().trim()
            val repeatPassword = binding.signUpRepeatPassword.editText.text.toString().trim()

            viewModel.signUp(nickname, password, repeatPassword)
        }

        binding.haveAccountButton.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setObservers() {
        viewModel.validationState.observe(this) { state ->
            if (state.isNicknameCorrect) {
                binding.signUpNickname.layout.hideError()
            } else {
                binding.signUpNickname.layout.showError(R.string.error_nickname)
            }

            if (state.isPasswordCorrect) {
                binding.signUpPassword.layout.hideError()
            } else {
                binding.signUpPassword.layout.showError(R.string.error_password)
            }

            if (state.isRepeatPasswordCorrect) {
                binding.signUpRepeatPassword.layout.hideError()
            } else {
                binding.signUpRepeatPassword.layout.showError(R.string.error_repeat_password)
            }
        }

        viewModel.isSignUpSuccessful.observe(this) {
            val intent = Intent(this, HubActivity::class.java)
            intent.clearStack()
            startActivity(intent)
        }
    }
}