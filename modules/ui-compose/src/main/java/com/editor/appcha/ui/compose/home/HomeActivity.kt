package com.editor.appcha.ui.compose.home

import android.os.Bundle
import androidx.activity.compose.setContent
import com.editor.appcha.core.ui.event.EmptyViewEvent
import com.editor.appcha.core.ui.viewmodel.EmptyViewModel
import com.editor.appcha.ui.compose.base.BaseActivity
import com.editor.appcha.ui.compose.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<EmptyViewModel, EmptyViewEvent>() {

    override val vm: EmptyViewModel = EmptyViewModel()

    override fun handleEvent(event: EmptyViewEvent) = Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                Home()
            }
        }
    }
}
