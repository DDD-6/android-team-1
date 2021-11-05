package com.editor.appcha.ui.feed.detail

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import com.editor.appcha.ui.R
import com.editor.appcha.ui.base.BaseActivity
import com.editor.appcha.ui.base.EmptyViewEvent
import com.editor.appcha.ui.base.EmptyViewModel
import com.editor.appcha.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedDetailActivity : BaseActivity<EmptyViewModel, EmptyViewEvent>() {

    override val viewModel: EmptyViewModel = EmptyViewModel()

    override fun handleEvent(event: EmptyViewEvent) {
        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {

            }
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.push_pop_enter, R.anim.push_pop_exit)
    }

    companion object {
        private const val KEY_FEED_ID = "KEY_FEED_ID"

        fun launch(context: Context, feedId: String) {
            val intent = Intent(context, FeedDetailActivity::class.java)
                .putExtra(KEY_FEED_ID, feedId)
            context.startActivity(intent)

            if (context is Activity) {
                context.overridePendingTransition(R.anim.push_enter, R.anim.push_exit)
            }
        }
    }
}
