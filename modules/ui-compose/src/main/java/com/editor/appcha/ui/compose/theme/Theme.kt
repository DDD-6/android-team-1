package com.editor.appcha.ui.compose.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun AppChaTheme(content: @Composable() () -> Unit) {
    MaterialTheme(
        colors = AppChaColors,
        typography = AppChaTypography,
        shapes = AppChaShapes,
        content = content
    )
}
