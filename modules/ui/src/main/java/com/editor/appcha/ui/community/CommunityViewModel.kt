package com.editor.appcha.ui.community

import com.editor.appcha.ui.base.BaseViewModel
import com.editor.appcha.ui.base.EmptyViewEvent
import com.editor.appcha.ui.base.ViewState
import com.editor.appcha.ui.community.CommunityViewModel.State
import com.editor.appcha.ui.model.BoardModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CommunityViewModel @Inject constructor(

) : BaseViewModel<EmptyViewEvent, State>(State()) {

    data class State(
        val boards: List<BoardModel>? = null
    ) : ViewState

    init {
        updateState { State(emptyList()) }
    }
}
