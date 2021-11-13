package com.editor.appcha.ui.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import com.editor.appcha.ui.R
import com.editor.appcha.ui.base.BaseActivity
import com.editor.appcha.ui.home.HomeActivity
import com.editor.appcha.ui.login.LoginActivity
import com.editor.appcha.ui.splash.SplashViewModel.Event
import com.editor.appcha.ui.theme.SplashTheme
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity<SplashViewModel, Event>() {

    override val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            SplashTheme {
                SplashScreen()
            }
        }
    }

    override fun handleEvent(event: Event) = when (event) {
        Event.StartMain -> startMainActivity()
        Event.StartSignIn -> startSignInActivity()
    }

    private fun startMainActivity() {
        HomeActivity.launch(this)
        overridePendingTransition(R.anim.push_enter, R.anim.push_exit)
        finish()
    }

    private fun startSignInActivity() {
        LoginActivity.launch(this)
        overridePendingTransition(R.anim.push_enter, R.anim.push_exit)
        finish()
    }
}
