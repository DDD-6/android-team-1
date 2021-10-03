package com.editor.appcha.ui.compose.splash

import com.editor.appcha.core.ui.event.EmptyViewEvent
import com.editor.appcha.core.ui.state.EmptyViewState
import com.editor.appcha.core.ui.viewmodel.BaseViewModel
import com.editor.appcha.domain.usecase.SayHelloUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val sayHelloUseCase: SayHelloUseCase
) : BaseViewModel<EmptyViewEvent, EmptyViewState>(EmptyViewState) {


    init {
        launch {
            sayHelloUseCase("Name")
        }
    }
}
