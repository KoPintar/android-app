package com.bangkit.kopintar.view.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.kopintar.databinding.ActivityMainBinding
import com.bangkit.kopintar.view.viewModelFactory.ViewModelFactory
import com.bangkit.kopintar.view.welcome.WelcomeActivity

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels {
        ViewModelFactory.getInstance(
            applicationContext
        )
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.getSession().observe(this) { user ->
            if (!user.isLogin) {
                startActivity(Intent(this, WelcomeActivity::class.java))
                finish()
            }
        }
    }
}