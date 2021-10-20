package com.editor.appcha.ui.splash

import com.editor.appcha.core.ui.event.ViewEvent
import com.editor.appcha.core.ui.state.ViewState
import com.editor.appcha.core.ui.viewmodel.AbstractViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.editor.appcha.ui.splash.SplashViewModel.Event
import com.editor.appcha.ui.splash.SplashViewModel.State
import kotlinx.coroutines.delay
import java.util.*

@HiltViewModel
class SplashViewModel @Inject constructor(): AbstractViewModel<Event, State>(State()) {

    sealed class Event : ViewEvent {
        object Exist: Event()
        object Expired: Event()
    }

    data class State(
        val loading: Boolean = false
    ) : ViewState

    init {
        getCurrentUser()
    }

    private fun getCurrentUser() {
        //TODO("서버 API 확인필요")
        launch {
            delay(3000)
            if (Random().nextBoolean()) {
                event(Event.Exist)
            } else {
                event(Event.Expired)
            }
        }
    }
}