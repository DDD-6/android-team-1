package com.editor.appcha.ui.compose.splash

import android.os.Bundle
import androidx.activity.compose.setContent
import com.editor.appcha.core.ui.event.EmptyViewEvent
import com.editor.appcha.core.ui.viewmodel.EmptyViewModel
import com.editor.appcha.ui.compose.base.BaseActivity
import com.editor.appcha.ui.compose.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<EmptyViewModel, EmptyViewEvent>() {

    override val vm: EmptyViewModel = EmptyViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                SplashScreen()
            }
        }
    }

    override fun handleEvent(event: EmptyViewEvent) = Unit
}


