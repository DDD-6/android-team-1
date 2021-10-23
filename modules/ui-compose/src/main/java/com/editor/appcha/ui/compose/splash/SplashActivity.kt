package com.editor.appcha.ui.compose.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.ui.graphics.Color
import com.editor.appcha.navigation.HomeNavigator
import com.editor.appcha.ui.compose.R
import com.editor.appcha.ui.compose.base.BaseActivity
import com.editor.appcha.ui.compose.login.LoginActivity
import com.editor.appcha.ui.compose.splash.SplashViewModel.Event
import com.editor.appcha.ui.compose.theme.AppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity<SplashViewModel, Event>() {

    override val vm: SplashViewModel by viewModels()

    @Inject
    lateinit var homeNavigator: HomeNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.setSystemBarsColor(color = Color.White)

            AppTheme {
                SplashScreen()
            }
        }
    }

    override fun handleEvent(event: Event) = when (event) {
        Event.StartMain -> startMainActivity()
        Event.StartSignIn -> startSignInActivity()
    }

    private fun startMainActivity() {
        homeNavigator.launch(this)
        overridePendingTransition(R.anim.push_enter, R.anim.push_exit)
        finish()
    }

    private fun startSignInActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
        overridePendingTransition(R.anim.push_enter, R.anim.push_exit)
        finish()
    }
}
