package com.editor.appcha.ui.compose.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.editor.appcha.ui.compose.R
import com.editor.appcha.ui.compose.component.AppText
import com.editor.appcha.ui.compose.theme.AppTheme

@Composable
fun SplashScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        AppText(
            text = stringResource(R.string.app_name),
            color = AppTheme.colors.primary,
            style = MaterialTheme.typography.h1
        )
    }
}

@Preview(widthDp = 300, heightDp = 400)
@Composable
fun SplashScreenPreview() {
    AppTheme {
        SplashScreen()
    }
}
