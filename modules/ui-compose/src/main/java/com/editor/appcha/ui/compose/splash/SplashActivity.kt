package com.editor.appcha.ui.compose.splash

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.editor.appcha.core.ui.event.EmptyViewEvent
import com.editor.appcha.ui.compose.base.BaseActivity
import com.editor.appcha.ui.compose.base.EmptyViewModel
import com.editor.appcha.ui.compose.theme.AppChaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<EmptyViewModel, EmptyViewEvent>() {

    override val vm: EmptyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppChaTheme {
                SplashScreen()
            }
        }
    }

    override fun handleEvent(event: EmptyViewEvent) = Unit
}
