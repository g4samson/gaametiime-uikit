package com.profs.uikit.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

internal val LocalLibraryColors = staticCompositionLocalOf<ColorScheme> {
    error("nope")
}

internal val LocalLibraryTypography = staticCompositionLocalOf<Typography> {
    error("nope")
}

object UikitLibraryTheme {
    val colorScheme: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalLibraryColors.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalLibraryTypography.current
}