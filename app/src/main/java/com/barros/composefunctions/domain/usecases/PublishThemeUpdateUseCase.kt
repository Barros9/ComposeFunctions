package com.barros.composefunctions.domain.usecases

import com.barros.composefunctions.domain.model.Theme
import javax.inject.Inject

class PublishThemeUpdateUseCase @Inject constructor() {
    suspend operator fun invoke(update: Theme) {
        themeUpdateFlow.emit(update)
    }
}