package com.editor.appcha.ui.community

import com.editor.appcha.core.arch.usecase.invoke
import com.editor.appcha.domain.usecase.GetBoardListUseCase
import com.editor.appcha.ui.base.BaseViewModel
import com.editor.appcha.ui.base.ViewEvent
import com.editor.appcha.ui.base.ViewState
import com.editor.appcha.ui.community.CommunityViewModel.Event
import com.editor.appcha.ui.community.CommunityViewModel.State
import com.editor.appcha.ui.model.BoardModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CommunityViewModel @Inject constructor(
    private val getBoards: GetBoardListUseCase
) : BaseViewModel<Event, State>(State()) {

    sealed class Event : ViewEvent {
        data class NavigateToDetail(val boardId: String) : Event()
        object NavigateToPost : Event()
    }

    data class State(
        val boards: List<BoardModel>? = null
    ) : ViewState

    init {
        launch {
            val boards = getBoards()
                .map { domain -> domain.map { BoardModel(it) } }
                .getOrThrow()
            updateState { State(boards = boards) }
        }
    }

    fun navigateToDetail(board: BoardModel) {
        event(Event.NavigateToDetail(board.id))
    }

    fun navigateToPost() {
        event(Event.NavigateToPost)
    }
}
