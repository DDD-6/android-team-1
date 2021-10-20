package com.editor.appcha.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.editor.appcha.core.ui.activity.AbstractActivity
import com.editor.appcha.ui.login.LoginActivity
import com.editor.appcha.ui.main.GreeterActivity
import com.editor.appcha.ui.theme.AppChaTheme
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : AbstractActivity<SplashViewModel, SplashViewModel.Event>() {

    override val vm by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppChaTheme {
                SplashScreen()
            }
        }
    }

    override fun handleEvent(event: SplashViewModel.Event) {
        when (event) {
            is SplashViewModel.Event.Exist -> {
                startActivity(Intent(this, GreeterActivity::class.java))
                finish()
            }
            is SplashViewModel.Event.Expired -> {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }
}
