package com.barros.composefunctions.domain.usecase

import com.barros.composefunctions.domain.repository.UserPreferencesRepository
import javax.inject.Inject

class SaveThemePreferencesUseCase @Inject constructor(
    private val repository: UserPreferencesRepository
) {
    suspend operator fun invoke(theme: String) = repository.saveThemePreferences(theme)
}