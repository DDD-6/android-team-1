package com.editor.appcha.ui.compose.login

import com.editor.appcha.core.ui.event.ViewEvent
import com.editor.appcha.core.ui.state.ViewState
import com.editor.appcha.core.ui.viewmodel.BaseViewModel
import com.editor.appcha.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import com.editor.appcha.ui.compose.login.LoginViewModel.Event
import com.editor.appcha.ui.compose.login.LoginViewModel.State
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : BaseViewModel<Event, State>(State()) {

    sealed class Event: ViewEvent {
        object StartHome : Event()
        object ShowErrorToast: Event()
    }

    data class State(
        val error: String = "",
        val isLoading: Boolean = false
    ) : ViewState

    fun login(token: String) = launch {
        loginUseCase(token)
            .onStart {
                updateState { it.copy(isLoading = true) }
            }
            .onCompletion {
                updateState { it.copy(isLoading = false) }
            }
            .catch { exception ->
                updateState { it.copy(error = exception.message.toString(), isLoading = false) }
            }
            .collect {
                if (it.isExist) {
                    event(Event.Success)
                }
            }
    }
}