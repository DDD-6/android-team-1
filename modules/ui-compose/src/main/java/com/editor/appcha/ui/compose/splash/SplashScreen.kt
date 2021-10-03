package com.editor.appcha.ui.compose.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.editor.appcha.ui.compose.component.AppChaText
import com.editor.appcha.ui.compose.theme.AppChaTheme

@Composable
fun SplashScreen() {
    val scrollState = rememberScrollState()
    Column(Modifier.verticalScroll(scrollState)) {
        AppChaText(
            text = "Body",
            style = MaterialTheme.typography.h1,
            color = AppChaTheme.colors.statusCaution
        )
        Column(
            modifier = Modifier
                .padding(top = 12.dp)
                .background(Color.Gray.copy(alpha = 0.4f))
        ) {
            AppChaText(
                text = "스포카 한스를 사용합니다.",
                style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
                color = AppChaTheme.colors.gray5
            )
            AppChaText(
                text = "스포카 한스를 사용합니다.",
                style = MaterialTheme.typography.body1,
                color = AppChaTheme.colors.gray3
            )
        }
    }
}


@Preview
@Composable
fun SplashScreenPreview() {
    AppChaTheme {
        SplashScreen()
    }
}

