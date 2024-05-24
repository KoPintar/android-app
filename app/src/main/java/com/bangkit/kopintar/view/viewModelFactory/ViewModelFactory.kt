package com.bangkit.kopintar.view.viewModelFactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bangkit.kopintar.data.repository.UserRepository
import com.bangkit.kopintar.di.Injection
import com.bangkit.kopintar.view.main.MainViewModel

class ViewModelFactory(
    private val userRepository: UserRepository,
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(userRepository) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @JvmStatic
        fun getInstance(context: Context) = ViewModelFactory(
            Injection.provideUserRepository(context),
        )
    }
}