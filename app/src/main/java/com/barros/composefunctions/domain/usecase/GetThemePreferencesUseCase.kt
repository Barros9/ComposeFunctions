package com.barros.composefunctions.domain.usecase

import com.barros.composefunctions.domain.repository.UserPreferencesRepository
import javax.inject.Inject

class GetThemePreferencesUseCase @Inject constructor(
    private val repository: UserPreferencesRepository
) {
    suspend operator fun invoke(): String = repository.getThemePreferences()
}