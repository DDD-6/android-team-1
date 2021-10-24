package com.editor.appcha.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import com.editor.appcha.ui.base.BaseActivity
import com.editor.appcha.ui.base.EmptyViewEvent
import com.editor.appcha.ui.base.EmptyViewModel
import com.editor.appcha.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<EmptyViewModel, EmptyViewEvent>() {

    override val viewModel: EmptyViewModel = EmptyViewModel()

    override fun handleEvent(event: EmptyViewEvent) = Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                Home()
            }
        }
    }

    companion object {

        fun launch(context: Context) {
            val intent = Intent(context, HomeActivity::class.java)
            context.startActivity(intent)
        }
    }
}
