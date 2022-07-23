package com.barros.composefunctions.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = Blue600,
    primaryVariant = Blue800,
    secondary = Orange800,
    secondaryVariant = Orange800
)

private val DarkColorPalette = darkColors(
    primary = Blue200,
    primaryVariant = Blue800,
    secondary = Orange300,
    secondaryVariant = Orange300
)
@Composable
fun ComposeFunctionsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}