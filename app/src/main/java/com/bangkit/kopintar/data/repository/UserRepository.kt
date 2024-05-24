package com.bangkit.kopintar.data.repository

import com.bangkit.kopintar.data.model.UserModel
import com.bangkit.kopintar.data.pref.UserPreference
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userPreference: UserPreference) {
    suspend fun saveSession(user: UserModel) {
        userPreference.saveSession(user)
    }

    fun getSession(): Flow<UserModel> {
        return userPreference.getSession()
    }

    suspend fun logout() {
        userPreference.logout()
    }

    companion object {
        fun getInstance(userPreference: UserPreference) = UserRepository(userPreference)
    }
}