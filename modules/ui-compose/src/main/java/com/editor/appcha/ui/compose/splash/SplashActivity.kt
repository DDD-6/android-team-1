package com.editor.appcha.ui.compose.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.editor.appcha.ui.compose.base.BaseActivity
import com.editor.appcha.ui.compose.splash.SplashViewModel.Event
import com.editor.appcha.ui.compose.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity<SplashViewModel, Event>() {

    override val vm: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
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
        Log.i(TAG, "startMainActivity")
        // TODO: MainActivity 시작
    }

    private fun startSignInActivity() {
        Log.i(TAG, "startSignInActivity")
        // TODO: SignInActivity 시작
    }
}


