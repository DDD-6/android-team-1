package com.editor.appcha.ui.community.detail

import androidx.lifecycle.SavedStateHandle
import com.editor.appcha.core.arch.mapList
import com.editor.appcha.domain.model.request.PostComment
import com.editor.appcha.domain.usecase.GetBoardUseCase
import com.editor.appcha.domain.usecase.GetCommentListUseCase
import com.editor.appcha.domain.usecase.PostCommentUseCase
import com.editor.appcha.ui.base.BaseViewModel
import com.editor.appcha.ui.base.ViewEvent
import com.editor.appcha.ui.base.ViewState
import com.editor.appcha.ui.community.detail.CommunityDetailViewModel.Event
import com.editor.appcha.ui.community.detail.CommunityDetailViewModel.State
import com.editor.appcha.ui.model.BoardModel
import com.editor.appcha.ui.model.CommentModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import javax.inject.Inject

@HiltViewModel
class CommunityDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getBoardUseCase: GetBoardUseCase,
    private val getCommentListUseCase: GetCommentListUseCase,
    private val postCommentUseCase: PostCommentUseCase
) : BaseViewModel<Event, State>(State()) {

    sealed class Event : ViewEvent {

        object NavigateUp : Event()
    }

    data class State(
        val board: BoardModel? = null,
        val comments: List<CommentModel>? = null,
        val input: String = ""
    ) : ViewState {

        val loading: Boolean = board == null

        val enabled: Boolean = board != null
    }

    init {
        val boardId: String = savedStateHandle.get(KEY_BOARD_ID) ?: ""
        fetchBoard(boardId)
    }

    private fun fetchBoard(boardId: String) {
        launch {
            val deferreds = awaitAll(
                async { getBoardUseCase(boardId).map { BoardModel(it) } },
                async { getCommentListUseCase(boardId).mapList { CommentModel(it) } }
            )
            val board = deferreds[0].getOrThrow() as BoardModel
            val comments = deferreds[1].getOrThrow() as List<CommentModel>

            updateState { state ->
                state.copy(
                    board = board,
                    comments = comments
                )
            }
        }
    }

    fun onInputChange(input: String) = updateState { state -> state.copy(input = input) }

    fun postComment() {
        val board = state.value.board ?: return
        val input = state.value.input
        if (input.isEmpty()) return

        launch {
            val request = PostComment(board.id, input)
            postCommentUseCase(request).getOrThrow()
            updateState { state -> state.copy(input = "") }
            fetchBoard(board.id)
        }
    }

    fun navigateUp() {
        event(Event.NavigateUp)
    }

    companion object {
        const val KEY_BOARD_ID = "KEY_BOARD_ID"
    }
}
