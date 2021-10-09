package com.editor.appcha.ui.compose.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Composable
fun AppTheme(content: @Composable() () -> Unit) {
    ProvideAppColors(colors = AppColors.Default) {
        MaterialTheme(
            typography = AppTypography,
            shapes = AppShapes,
            content = content
        )
    }
}

object AppTheme {

    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppChaColors.current
}

@Stable
class AppColors(
    gray1: Color = Gray1,
    gray2: Color = Gray2,
    gray3: Color = Gray3,
    gray4: Color = Gray4,
    gray5: Color = Gray5,
    primary: Color = Primary,
    primaryLight: Color = PrimaryLight,
    statusError: Color = StatusError,
    statusCaution: Color = StatusCaution,
) {
    var gray1 by mutableStateOf(gray1)
        private set
    var gray2 by mutableStateOf(gray2)
        private set
    var gray3 by mutableStateOf(gray3)
        private set
    var gray4 by mutableStateOf(gray4)
        private set
    var gray5 by mutableStateOf(gray5)
        private set
    var primary by mutableStateOf(primary)
        private set
    var primaryLight by mutableStateOf(primaryLight)
        private set
    var statusError by mutableStateOf(statusError)
        private set
    var statusCaution by mutableStateOf(statusCaution)
        private set

    fun copy(
        gray1: Color = this.gray1,
        gray2: Color = this.gray2,
        gray3: Color = this.gray3,
        gray4: Color = this.gray4,
        gray5: Color = this.gray5,
        primary: Color = this.primary,
        primaryLight: Color = this.primaryLight,
        statusError: Color = this.statusError,
        statusCaution: Color = this.statusCaution,
    ): AppColors = AppColors(
        gray1 = gray1,
        gray2 = gray2,
        gray3 = gray3,
        gray4 = gray4,
        gray5 = gray5,
        primary = primary,
        primaryLight = primaryLight,
        statusError = statusError,
        statusCaution = statusCaution
    )

    companion object {

        val Default = AppColors()
    }
}

@Composable
fun ProvideAppColors(
    colors: AppColors,
    content: @Composable () -> Unit
) {
    val rememberedColors = remember {
        // Explicitly creating a new object here so we don't mutate the initial [colors]
        // provided, and overwrite the values set in it.
        colors.copy()
    }
    CompositionLocalProvider(LocalAppChaColors provides rememberedColors, content = content)
}

private val LocalAppChaColors = staticCompositionLocalOf { AppColors.Default }
