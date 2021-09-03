package com.editor.appcha.core.arch.sample

import com.editor.appcha.core.arch.usecase.ResultUseCase
import com.editor.appcha.domain.model.Greeter
import kotlinx.coroutines.delay

class GreeterUseCase : ResultUseCase<String, Greeter>() {

    override suspend fun execute(param: String): Greeter {
        delay(500L)
        return Greeter("Hello $param")
    }
}
