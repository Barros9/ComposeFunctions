package com.barros.composefunctions.domain.usecase

import com.barros.composefunctions.domain.model.Theme
import com.barros.composefunctions.domain.repository.UserPreferencesRepository
import javax.inject.Inject

class PublishThemeUpdateUseCase @Inject constructor(
    private val repository: UserPreferencesRepository
) {
    suspend operator fun invoke(theme: Theme) = repository.publishThemeUpdate(theme)
}