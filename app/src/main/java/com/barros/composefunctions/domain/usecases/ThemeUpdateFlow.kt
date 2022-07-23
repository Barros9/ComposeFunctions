package com.barros.composefunctions.domain.usecases

import com.barros.composefunctions.domain.model.Theme
import kotlinx.coroutines.flow.MutableSharedFlow

internal val themeUpdateFlow = MutableSharedFlow<Theme>()