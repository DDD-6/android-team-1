package com.editor.appcha.ui.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.editor.appcha.ui.theme.AppTheme

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        val lottieComposition by rememberLottieComposition(LottieCompositionSpec.Asset("lottie_splash.json"))
        LottieAnimation(
            composition = lottieComposition,
            contentScale = ContentScale.FillWidth)
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun SplashScreenPreview() {
    AppTheme {
        SplashScreen()
    }
}
