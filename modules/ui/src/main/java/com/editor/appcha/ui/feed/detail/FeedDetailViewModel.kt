package com.editor.appcha.ui.feed.detail

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
    private val getFeed: GetFeedUseCase
) : BaseViewModel<EmptyViewEvent, State>(State()) {

    data class State(val feed: FeedDetailModel? = null) : ViewState

    init {
        launch {
            when (val result = getFeed("")) {
                is Result.Success -> updateState { it.copy(feed = FeedDetailModel(result.value)) }
                is Result.Failure -> updateState { State() }
            }
        }
    }
}
