package com.editor.appcha.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.editor.appcha.core.ui.activity.AbstractActivity
import com.editor.appcha.ui.theme.AppChaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GreeterActivity : AbstractActivity<GreeterViewModel, GreeterViewModel.Event>() {

    override val vm by viewModels<GreeterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppChaTheme {
                GreeterActivityScreen(vm)
            }
        }
    }

    override fun handleEvent(event: GreeterViewModel.Event) {
        // no-op
    }
}
