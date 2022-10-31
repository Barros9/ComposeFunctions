package com.barros.composefunctions.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barros.composefunctions.domain.model.Theme
import com.barros.composefunctions.domain.usecase.GetThemePreferencesUseCase
import com.barros.composefunctions.domain.usecase.GetThemeUpdateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getThemePreferencesUseCase: GetThemePreferencesUseCase,
    private val getThemeUpdateUseCase: GetThemeUpdateUseCase
) : ViewModel() {

    private val _theme by lazy { mutableStateOf(Theme.Light) }
    val theme: State<Theme> by lazy { _theme.apply { updateTheme() } }

    init {
        viewModelScope.launch {
            getThemeUpdateUseCase().collect { _theme.value = it }
        }
    }

    private fun updateTheme() {
        viewModelScope.launch {
            _theme.value = Theme.valueOf(getThemePreferencesUseCase())
        }
    }
}