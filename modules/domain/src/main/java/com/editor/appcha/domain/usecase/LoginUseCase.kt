package com.editor.appcha.domain.usecase

import com.editor.appcha.domain.model.User
import com.editor.appcha.domain.repo.LoginRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    operator fun invoke(token: String): Flow<User> = loginRepository.loginKakao(token)
}