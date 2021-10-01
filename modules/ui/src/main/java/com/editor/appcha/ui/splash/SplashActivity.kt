package com.editor.appcha.ui.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Button
import androidx.compose.material.Text
import com.editor.appcha.ui.base.BaseActivity
import com.editor.appcha.ui.main.MainNavigatorImpl
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity<SplashViewModel, SplashViewModel.Event>() {

    override val vm by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navigator = MainNavigatorImpl

        setContent {
            Button(
                onClick = { navigator.launch(this) }
            ) {
                Text("Main")
            }
        }
    }

    override fun handleEvent(event: SplashViewModel.Event) {
        //TODO("Not yet implemented")
    }
}
