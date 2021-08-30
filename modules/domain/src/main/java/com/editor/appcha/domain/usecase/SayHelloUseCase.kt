package com.editor.appcha.domain.usecase

import com.editor.appcha.domain.model.Greeter
import com.editor.appcha.domain.repo.GreeterRepository

class SayHelloUseCase constructor(
    private val repo: GreeterRepository
) {

    operator fun invoke(name: String): Greeter = repo.sayHello(name)
}
