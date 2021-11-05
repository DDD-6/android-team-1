package com.editor.appcha.ui.feed.detail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.editor.appcha.core.arch.Result
import com.editor.appcha.domain.usecase.GetFeedUseCase
import com.editor.appcha.domain.usecase.UpdateFavoriteUseCase
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
    private val updateFavorite: UpdateFavoriteUseCase,
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

    fun toggleFavorite() {
        val feed = state.value.feed ?: return
        launch {
            val params = UpdateFavoriteUseCase.Params(
                feedId = feed.id,
                isFavorite = feed.isFavorite.not()
            )
            updateFavorite(params)
                .onFailure { Log.e(TAG, "찜하기 상태 변경 실패 $feed") }
        }
        updateState { state ->
            state.copy(feed = feed.copy(isFavorite = feed.isFavorite.not()))
        }
    }

    companion object {
        const val KEY_FEED_ID = "KEY_FEED_ID"
    }
}
