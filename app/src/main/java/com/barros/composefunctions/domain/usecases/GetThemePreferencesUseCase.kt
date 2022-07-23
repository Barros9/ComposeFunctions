package com.barros.composefunctions.domain.usecases

import com.barros.composefunctions.domain.repositories.UserPreferencesRepository
import javax.inject.Inject

class GetThemePreferencesUseCase @Inject constructor(
    private val repository: UserPreferencesRepository
) {
    suspend operator fun invoke(): String {
        return repository.getThemePreferences()
    }
}