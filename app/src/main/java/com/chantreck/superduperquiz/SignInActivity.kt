package com.chantreck.superduperquiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chantreck.superduperquiz.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySignInBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setViews()
    }

    private fun setViews() {
        with (binding.signInToolbar.toolbar) {
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
        }
    }
}