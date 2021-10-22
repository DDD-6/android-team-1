package com.editor.appcha.ui.compose.main

import android.os.Bundle
import androidx.activity.compose.setContent
import com.editor.appcha.core.ui.event.EmptyViewEvent
import com.editor.appcha.core.ui.viewmodel.EmptyViewModel
import com.editor.appcha.ui.compose.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<EmptyViewModel, EmptyViewEvent>() {

    override val vm: EmptyViewModel = EmptyViewModel()

    override fun handleEvent(event: EmptyViewEvent) = Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

        }
    }
}
