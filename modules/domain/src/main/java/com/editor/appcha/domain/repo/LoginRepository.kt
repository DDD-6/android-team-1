package com.editor.appcha.domain.repo

import com.editor.appcha.core.arch.Result
import com.editor.appcha.domain.model.User

interface LoginRepository {
    suspend fun loginKakao(token: String) : Result<User>
}