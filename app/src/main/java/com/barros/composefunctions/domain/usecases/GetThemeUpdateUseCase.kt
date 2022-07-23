package com.barros.composefunctions.domain.usecases

import com.barros.composefunctions.domain.model.Theme
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetThemeUpdateUseCase @Inject constructor() {
    operator fun invoke(): Flow<Theme> {
        return themeUpdateFlow
    }
}