package com.editor.appcha.domain.usecase

import com.editor.appcha.core.arch.Result
import com.editor.appcha.domain.model.Greeter
import com.editor.appcha.domain.repo.GreeterRepository
import javax.inject.Inject

class SayHelloUseCase @Inject constructor(
    private val repo: GreeterRepository
) {

    suspend operator fun invoke(name: String): Result<Greeter> = repo.sayHello(name)
}
