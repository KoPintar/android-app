package com.bangkit.kopintar.view.welcome

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.kopintar.R
import com.bangkit.kopintar.databinding.ActivityWelcomeBinding
import com.bangkit.kopintar.view.login.LoginActivity

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTitle.text = getString(R.string.welcome_title, getString(R.string.app_name))

        setupAction()
    }

    private fun setupAction() {
        binding.startButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}