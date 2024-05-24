package com.bangkit.kopintar.di

import android.content.Context
import com.bangkit.kopintar.data.pref.UserPreference
import com.bangkit.kopintar.data.pref.dataStore
import com.bangkit.kopintar.data.repository.UserRepository

object Injection {
    fun provideUserRepository(context: Context): UserRepository {
        val userPreference = UserPreference.getInstance(context.dataStore)
        return UserRepository.getInstance(userPreference)
    }
}