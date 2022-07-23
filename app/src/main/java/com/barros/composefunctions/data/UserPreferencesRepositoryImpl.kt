package com.barros.composefunctions.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.barros.composefunctions.domain.repositories.UserPreferencesRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

const val THEME_PREFERENCES_KEY = "theme_preferences_key"

class UserPreferencesRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : UserPreferencesRepository {

    override suspend fun getThemePreferences(): String {
        return runCatching {
            val preferencesKey = stringPreferencesKey(THEME_PREFERENCES_KEY)
            val preferences = dataStore.data.first()
            preferences[preferencesKey] ?: "Light"
        }.getOrElse { "Light" }
    }

    override suspend fun saveThemePreferences(value: String) {
        val preferencesKey = stringPreferencesKey(THEME_PREFERENCES_KEY)
        dataStore.edit { preferences -> preferences[preferencesKey] = value }
    }
}