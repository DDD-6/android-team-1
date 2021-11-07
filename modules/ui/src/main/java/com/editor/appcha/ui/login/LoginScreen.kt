package com.editor.appcha.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.editor.appcha.ui.R
import com.editor.appcha.ui.component.AppText
import com.editor.appcha.ui.theme.AppTheme
import com.editor.appcha.ui.theme.buttonKakao
import com.editor.appcha.ui.theme.kakaoButton
import com.editor.appcha.ui.theme.kakaoTitle

@Composable
fun LoginActivityScreen(viewModel: LoginViewModel, onKakao: () -> Unit) {
    val state by viewModel.state.collectAsState()

    LoginScreen(
        isLoading = state.isLoading,
        onKakao = onKakao
    )
}

@Composable
fun LoginScreen(
    isLoading: Boolean,
    onKakao: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(30.dp),
            verticalArrangement = Arrangement.Center
        ) {
            KakaoLoginButton(onClick = onKakao)
        }

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Composable
fun KakaoLoginButton(
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().height(buttonKakao),
        colors = ButtonDefaults.buttonColors(kakaoButton)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_kakao),
            contentDescription = "Kakao",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(10.dp))
        AppText(
            text = stringResource(R.string.kakao_title),
            color = kakaoTitle,
            style = AppTheme.typography.caption2)
    }
}
