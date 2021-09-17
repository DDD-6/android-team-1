package com.editor.appcha.ui.main

import com.editor.appcha.core.ui.event.ViewEvent
import com.editor.appcha.core.ui.state.ViewState
import com.editor.appcha.core.ui.viewmodel.AbstractViewModel
import com.editor.appcha.domain.usecase.GetNameUseCase
import com.editor.appcha.domain.usecase.SayHelloUseCase
import com.editor.appcha.ui.core.arch.sample.GreeterModel
import com.editor.appcha.ui.core.arch.sample.GreeterUseCase
import com.editor.appcha.ui.main.GreeterViewModel.Event
import com.editor.appcha.ui.main.GreeterViewModel.State
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GreeterViewModel @Inject constructor(
    private val getNameUseCase: GetNameUseCase,
    private val sayHelloUseCase: SayHelloUseCase,
    private val greeterUseCase: GreeterUseCase
) : AbstractViewModel<Event, State>(State()) {

    sealed class Event : ViewEvent

    data class State(
        val input: String = "",
        val items: List<GreeterModel> = emptyList(),
        val loading: Boolean = false
    ) : ViewState

    init {
        fetchName()
    }

    private fun fetchName() {
        updateState { it.copy(input = getNameUseCase()) }
    }

    fun sayHello() {
        launch {
            updateState { it.copy(loading = true) }
            val name = state.value.input

            val greeter = greeterUseCase(name).getOrThrow()
            updateState { state ->
                state.copy(
                    input = "",
                    items = state.items + GreeterModel(greeter.message),
                    loading = false
                )
            }
        }
    }

    fun onInputChanged(input: String) = updateState { it.copy(input = input) }
}
