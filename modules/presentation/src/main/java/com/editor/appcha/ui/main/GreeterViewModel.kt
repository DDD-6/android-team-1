package com.editor.appcha.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.editor.appcha.domain.usecase.GetNameUseCase
import com.editor.appcha.domain.usecase.SayHelloUseCase
import kotlinx.coroutines.launch

class GreeterViewModel(
    private val getNameUseCase: GetNameUseCase,
    private val sayHelloUseCase: SayHelloUseCase
) : ViewModel() {

    val input: MutableState<String> = mutableStateOf("")
    val items: MutableState<List<String>> = mutableStateOf(emptyList())

    init {
        fetchName()
    }

    fun fetchName() {
        viewModelScope.launch {
            input.value = getNameUseCase()
        }
    }

    fun sayHello() {
        viewModelScope.launch {
            val name = input.value
            val message = sayHelloUseCase(name).message
            input.value = ""
            items.value = items.value + listOf(message)
        }
    }

    fun onInputChanged(input: String) {
        this.input.value = input
    }

    class Factory(
        private val getNameUseCase: GetNameUseCase,
        private val sayHelloUseCase: SayHelloUseCase
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T = GreeterViewModel(
            getNameUseCase = getNameUseCase,
            sayHelloUseCase = sayHelloUseCase
        ) as T
    }
}
