package com.editor.appcha.ui.login

import com.editor.appcha.ui.base.ViewEvent
import com.editor.appcha.domain.usecase.LoginUseCase
import com.editor.appcha.ui.base.BaseViewModel
import com.editor.appcha.ui.base.ViewState
import com.editor.appcha.ui.login.LoginViewModel.Event
import com.editor.appcha.ui.login.LoginViewModel.State
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : BaseViewModel<Event, State>(State()) {

    sealed class Event : ViewEvent {
        object StartHome : Event()
        object ShowErrorToast : Event()
    }

    data class State(
        val error: String = "",
        val isLoading: Boolean = false
    ) : ViewState

    fun login(token: String) = launch {
//        loginUseCase(token)
//            .onStart {
//                updateState { it.copy(isLoading = true) }
//            }
//            .onCompletion {
//                updateState { it.copy(isLoading = false) }
//            }
//            .catch { exception ->
//                updateState { it.copy(error = exception.message.toString(), isLoading = false) }
//            }
//            .collect {
//                if (it.isExist) {
//                    event(Event.Success)
//                }
//            }
    }
}
