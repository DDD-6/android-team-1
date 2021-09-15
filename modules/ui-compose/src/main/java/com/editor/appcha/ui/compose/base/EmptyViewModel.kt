package com.editor.appcha.ui.compose.base

import com.editor.appcha.core.ui.event.EmptyViewEvent
import com.editor.appcha.core.ui.state.EmptyViewState
import com.editor.appcha.core.ui.state.ViewState

class EmptyViewModel : BaseViewModel<EmptyViewEvent, ViewState>(EmptyViewState)
