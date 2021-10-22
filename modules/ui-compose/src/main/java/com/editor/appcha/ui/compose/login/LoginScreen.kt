package com.editor.appcha.ui.compose.login

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.editor.appcha.ui.compose.login.provider.KakaoLoginProvider

@Composable
fun LoginActivityScreen(activity: Activity, viewModel: LoginViewModel, kakaoLoginProvider: KakaoLoginProvider) {
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    LoginScreen(
        isLoading = state.isLoading,
        onKakaoLoginClick = {
            kakaoLoginProvider.login(activity) { oAuthToken, throwable ->
                if (throwable != null) {
                    Toast.makeText(context, throwable.message, Toast.LENGTH_SHORT).show()
                } else {
                    oAuthToken?.accessToken?.let {
                        viewModel.login(it)
                    }
                }
            }
        }
    )
}

@Composable
fun LoginScreen(
    isLoading: Boolean,
    onKakaoLoginClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().background(Color.White).padding(32.dp),
            verticalArrangement = Arrangement.Center
        ) {
            KakaoLoginButton(onClick = onKakaoLoginClick)
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
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(Color.Yellow),
        contentPadding = PaddingValues(top = 12.dp, bottom = 12.dp)
    ) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Kakao",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("카카오 로그인")
    }
}
