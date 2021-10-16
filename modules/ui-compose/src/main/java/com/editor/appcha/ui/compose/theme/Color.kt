package com.editor.appcha.ui.compose.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Gray1 = Color(0xFFF0F0F0)
val Gray2 = Color(0xFFCDD2D7)
val Gray3 = Color(0xFF8C96A0)
val Gray4 = Color(0xFF505A64)
val Gray5 = Color(0xFF30323C)

val Primary = Color(0xFF6ACDC8)
val PrimaryLight = Color(0xFF6ACDC8)

val StatusError = Color(0xFFEB4B4B)
val StatusCaution = Color(0xFFFF8E3C)

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

internal val LocalAppColors = staticCompositionLocalOf { AppColors.Default }
