package com.editor.appcha.ui.splash

import com.editor.appcha.core.ui.event.ViewEvent
import com.editor.appcha.core.ui.state.ViewState
import com.editor.appcha.core.ui.viewmodel.AbstractViewModel
import com.editor.appcha.domain.usecase.SayHelloUseCase
import com.editor.appcha.ui.splash.SplashViewModel.Event
import com.editor.appcha.ui.splash.SplashViewModel.State
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    sayHelloUseCase: SayHelloUseCase
) : AbstractViewModel<Event, State>(State()) {

    sealed class Event : ViewEvent

    data class State(
        val loading: Boolean = false
    ) : ViewState

    init {
        launch {
            sayHelloUseCase("hi")
        }
    }
}
