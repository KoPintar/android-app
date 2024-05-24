package com.bangkit.kopintar.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bangkit.kopintar.data.model.UserModel
import com.bangkit.kopintar.data.repository.UserRepository

class MainViewModel(
    private val userRepository: UserRepository,
): ViewModel() {
    fun getSession(): LiveData<UserModel> {
        return userRepository.getSession().asLiveData()
    }
}