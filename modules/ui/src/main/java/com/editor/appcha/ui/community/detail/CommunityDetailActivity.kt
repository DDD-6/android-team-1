package com.editor.appcha.ui.community.detail

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.editor.appcha.ui.R
import com.editor.appcha.ui.base.BaseActivity
import com.editor.appcha.ui.community.detail.CommunityDetailViewModel.Event
import com.editor.appcha.ui.theme.AppTheme
import com.editor.appcha.ui.theme.StatusBarColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CommunityDetailActivity : BaseActivity<CommunityDetailViewModel, Event>() {

    override val viewModel: CommunityDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.setStatusBarColor(StatusBarColor)

            AppTheme {
                CommunityDetailScreen(viewModel = viewModel)
            }
        }
    }

    override fun handleEvent(event: Event) {
        when (event) {
            Event.NavigateUp -> finish()
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.push_pop_enter, R.anim.push_pop_exit)
    }

    companion object {
        fun launch(context: Context, boardId: String) {
            val intent = Intent(context, CommunityDetailActivity::class.java)
                .putExtra(CommunityDetailViewModel.KEY_BOARD_ID, boardId)
            context.startActivity(intent)

            if (context is Activity) {
                context.overridePendingTransition(R.anim.push_enter, R.anim.push_exit)
            }
        }
    }
}
