package com.barros.composefunctions.domain.usecase

import com.barros.composefunctions.domain.model.Theme
import com.barros.composefunctions.domain.repository.UserPreferencesRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetThemeUpdateUseCase @Inject constructor(
    private val repository: UserPreferencesRepository
) {
    suspend operator fun invoke(): Flow<Theme> = repository.getThemeUpdate()
}