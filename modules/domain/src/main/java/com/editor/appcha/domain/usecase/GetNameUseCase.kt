package com.editor.appcha.domain.usecase

import com.editor.appcha.domain.repo.GreeterRepository

class GetNameUseCase(
    private val repo: GreeterRepository
) {

    operator fun invoke(): String = repo.getName()
}
