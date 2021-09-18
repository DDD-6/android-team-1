package com.editor.appcha.ui.compose.base

import com.editor.appcha.core.ui.event.ViewEvent
import com.editor.appcha.core.ui.state.ViewState
import com.editor.appcha.core.ui.viewmodel.AbstractViewModel

abstract class BaseViewModel<VE : ViewEvent, VS : ViewState>(
    initialState: VS
) : AbstractViewModel<VE, VS>(initialState)
