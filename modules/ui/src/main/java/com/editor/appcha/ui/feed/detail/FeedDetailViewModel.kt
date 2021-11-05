package com.editor.appcha.ui.feed.detail

import androidx.lifecycle.SavedStateHandle
import com.editor.appcha.core.arch.Result
import com.editor.appcha.domain.usecase.GetFeedUseCase
import com.editor.appcha.ui.base.BaseViewModel
import com.editor.appcha.ui.base.EmptyViewEvent
import com.editor.appcha.ui.base.ViewState
import com.editor.appcha.ui.feed.detail.FeedDetailViewModel.State
import com.editor.appcha.ui.model.FeedDetailModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeedDetailViewModel @Inject constructor(
    private val getFeed: GetFeedUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<EmptyViewEvent, State>(State()) {

    data class State(val feed: FeedDetailModel? = null) : ViewState

    init {
        val feedId: String = savedStateHandle.get(KEY_FEED_ID) ?: ""
        if (feedId.isNotEmpty()) {
            fetchFeed(feedId)
        }
    }

    private fun fetchFeed(feedId: String) {
        launch {
            when (val result = getFeed(feedId)) {
                is Result.Success -> updateState { it.copy(feed = FeedDetailModel(result.value)) }
                is Result.Failure -> updateState { State() }
            }
        }
    }

    companion object {
        const val KEY_FEED_ID = "KEY_FEED_ID"
    }
}
