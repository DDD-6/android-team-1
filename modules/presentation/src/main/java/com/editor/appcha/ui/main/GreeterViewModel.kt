package com.editor.appcha.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.sample.GreeterModel
import com.editor.appcha.core.arch.sample.GreeterUseCase
import com.editor.appcha.domain.usecase.GetNameUseCase
import com.editor.appcha.domain.usecase.SayHelloUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class GreeterViewModel(
    private val getNameUseCase: GetNameUseCase,
    private val sayHelloUseCase: SayHelloUseCase
) : ViewModel() {

    private val greeterUseCase = GreeterUseCase()

    val input: MutableState<String> = mutableStateOf("")
    val items: MutableState<List<String>> = mutableStateOf(emptyList())

    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

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

            // TODO: BaseViewModel 에서 로딩 상태를 제어할 수 있는 공통 로직 필요
            greeterUseCase(name)
                .map { result -> result.map { GreeterModel(it) } }
                .collect { result ->
                    when (result) {
                        is Result.Loading -> _loading.value = true
                        is Result.Success -> {
                            _loading.value = false
                            input.value = ""
                            items.value = items.value + listOf(result.value.message)
                        }
                        is Result.Failure -> result.throwable.printStackTrace()
                    }
                }
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
