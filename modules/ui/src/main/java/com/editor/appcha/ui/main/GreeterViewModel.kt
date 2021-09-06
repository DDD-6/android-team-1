package com.editor.appcha.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.editor.appcha.core.ui.event.ViewEvent
import com.editor.appcha.core.ui.state.ViewState
import com.editor.appcha.core.ui.viewmodel.AbstractViewModel
import com.editor.appcha.domain.usecase.GetNameUseCase
import com.editor.appcha.domain.usecase.SayHelloUseCase
import com.editor.appcha.ui.core.arch.sample.GreeterModel
import com.editor.appcha.ui.core.arch.sample.GreeterUseCase
import com.editor.appcha.ui.main.GreeterViewModel.Event
import com.editor.appcha.ui.main.GreeterViewModel.State
import kotlinx.coroutines.flow.map

class GreeterViewModel(
    private val getNameUseCase: GetNameUseCase,
    private val sayHelloUseCase: SayHelloUseCase
) : AbstractViewModel<Event, State>(State()) {

    sealed class Event : ViewEvent

    data class State(
        val input: String = "",
        val items: List<GreeterModel> = emptyList()
    ) : ViewState

    private val greeterUseCase = GreeterUseCase()

    init {
        fetchName()
    }

    fun fetchName() {
        launch {
            updateState { it.copy(input = getNameUseCase()) }
        }
    }

    fun sayHello() {
        launch {
            val name = state.value.input
            greeterUseCase(name)
                .map { result -> result.map { GreeterModel(it) } }
                .collectResult { value ->
                    updateState {
                        it.copy(
                            input = "",
                            items = it.items + listOf(GreeterModel(value.message))
                        )
                    }
                }
        }
    }

    fun onInputChanged(input: String) = updateState { it.copy(input = input) }

    class Factory(
        private val getNameUseCase: GetNameUseCase,
        private val sayHelloUseCase: SayHelloUseCase
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T = GreeterViewModel(
            getNameUseCase = getNameUseCase,
            sayHelloUseCase = sayHelloUseCase
        ) as T
    }
}
