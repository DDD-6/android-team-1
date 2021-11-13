package com.editor.appcha.domain.usecase

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.usecase.UseCase
import com.editor.appcha.domain.repo.LoginRepository
import javax.inject.Inject

class IsLoggedInUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) : UseCase<Unit, Boolean>() {

    override suspend fun execute(param: Unit): Result<Boolean> = loginRepository.isLoggedIn()
}