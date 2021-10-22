package com.editor.appcha.domain.usecase

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.usecase.UseCase
import com.editor.appcha.domain.model.User
import com.editor.appcha.domain.repo.LoginRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) : UseCase<String, User>() {

    override suspend fun execute(param: String): Result<User> = loginRepository.loginKakao(param)
}