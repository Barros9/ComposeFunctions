package com.barros.composefunctions.data.repository

import com.barros.composefunctions.data.datasource.LocalDataSource
import com.barros.composefunctions.domain.model.Theme
import com.barros.composefunctions.domain.repository.UserPreferencesRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.SharedFlow

internal class UserPreferencesRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : UserPreferencesRepository {
    override suspend fun getThemeUpdate(): SharedFlow<Theme> = localDataSource.getThemeUpdate()

    override suspend fun publishThemeUpdate(theme: Theme) =
        localDataSource.publishThemeUpdate(theme)

    override suspend fun getThemePreferences(): String = localDataSource.getThemePreferences()

    override suspend fun saveThemePreferences(theme: String) =
        localDataSource.saveThemePreferences(theme)

}