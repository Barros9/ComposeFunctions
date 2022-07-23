package com.barros.composefunctions.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barros.composefunctions.domain.model.Theme
import com.barros.composefunctions.domain.usecases.PublishThemeUpdateUseCase
import com.barros.composefunctions.domain.usecases.SaveThemePreferencesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val saveThemePreferencesUseCase: SaveThemePreferencesUseCase,
    private val publishThemeUpdateUseCase: PublishThemeUpdateUseCase
) : ViewModel() {

    fun onThemeChanged(theme: Theme) {
        viewModelScope.launch {
            saveThemePreferencesUseCase(theme.name)
            publishThemeUpdateUseCase(theme)
        }
    }

}

