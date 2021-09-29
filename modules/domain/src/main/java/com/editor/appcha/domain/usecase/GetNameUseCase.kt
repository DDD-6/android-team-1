package com.editor.appcha.domain.usecase

import com.editor.appcha.domain.repo.GreeterRepository
import javax.inject.Inject

class GetNameUseCase @Inject constructor(
    private val repo: GreeterRepository
) {

    operator fun invoke(): String = repo.getName()
}
