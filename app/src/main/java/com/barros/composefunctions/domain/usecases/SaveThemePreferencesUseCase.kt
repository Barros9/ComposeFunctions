package com.barros.composefunctions.domain.usecases

import com.barros.composefunctions.domain.repositories.UserPreferencesRepository
import javax.inject.Inject

class SaveThemePreferencesUseCase @Inject constructor(
    private val repository: UserPreferencesRepository
) {
    suspend operator fun invoke(value: String) {
        return repository.saveThemePreferences(value)
    }
}