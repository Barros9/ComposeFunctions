package com.barros.composefunctions.data.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.barros.composefunctions.domain.model.Theme
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.first

internal class LocalDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>,
) : LocalDataSource {

    companion object {
        const val THEME_PREFERENCES_KEY = "theme_preferences_key"
    }

    private val themeUpdateFlow = MutableSharedFlow<Theme>()

    override suspend fun getThemeUpdate(): SharedFlow<Theme> = themeUpdateFlow

    override suspend fun publishThemeUpdate(theme: Theme) = themeUpdateFlow.emit(theme)

    override suspend fun getThemePreferences(): String {
        return runCatching {
            val preferencesKey = stringPreferencesKey(THEME_PREFERENCES_KEY)
            val preferences = dataStore.data.first()
            preferences[preferencesKey] ?: "Light"
        }.getOrElse { "Light" }
    }

    override suspend fun saveThemePreferences(theme: String) {
        val preferencesKey = stringPreferencesKey(THEME_PREFERENCES_KEY)
        dataStore.edit { preferences -> preferences[preferencesKey] = theme }
    }

}