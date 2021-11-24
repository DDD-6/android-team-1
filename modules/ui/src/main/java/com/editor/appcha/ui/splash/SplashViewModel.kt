package com.editor.appcha.ui.splash

import com.editor.appcha.core.arch.usecase.invoke
import com.editor.appcha.ui.base.ViewEvent
import com.editor.appcha.ui.base.EmptyViewState
import com.editor.appcha.ui.base.BaseViewModel
import com.editor.appcha.domain.usecase.IsLoggedInUseCase
import com.editor.appcha.ui.splash.SplashViewModel.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val isLoggedInUseCase: IsLoggedInUseCase
) : BaseViewModel<Event, EmptyViewState>(EmptyViewState) {

    init {
        launch {
            val splashJob = launch { delay(SPLASH_TIME) }
            val isLoggedIn = isLoggedInUseCase()
            splashJob.join()

            when (isLoggedIn.getOrThrow()) {
                true -> event(Event.StartMain)
                false -> event(Event.StartSignIn)
            }
        }
    }

    sealed class Event : ViewEvent {
        object StartMain : Event()
        object StartSignIn : Event()
    }

    companion object {
        private const val SPLASH_TIME = 3000L
    }
}
