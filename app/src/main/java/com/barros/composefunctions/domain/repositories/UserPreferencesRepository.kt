package com.barros.composefunctions.domain.repositories

interface UserPreferencesRepository {
    suspend fun getThemePreferences(): String
    suspend fun saveThemePreferences(value: String)
}