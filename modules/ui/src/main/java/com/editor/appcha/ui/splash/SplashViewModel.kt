package com.editor.appcha.ui.splash

import com.editor.appcha.core.ui.event.ViewEvent
import com.editor.appcha.core.ui.state.ViewState
import com.editor.appcha.core.ui.viewmodel.AbstractViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.editor.appcha.ui.splash.SplashViewModel.Event
import com.editor.appcha.ui.splash.SplashViewModel.State

@HiltViewModel
class SplashViewModel @Inject constructor(): AbstractViewModel<Event, State>(State()) {

    sealed class Event : ViewEvent

    data class State(
        val loading: Boolean = false
    ) : ViewState
}