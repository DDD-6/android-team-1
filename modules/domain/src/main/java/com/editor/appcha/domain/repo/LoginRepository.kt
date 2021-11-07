package com.editor.appcha.domain.repo

import com.editor.appcha.core.arch.Result
import com.editor.appcha.domain.model.Profile

interface LoginRepository {
    suspend fun isLoggedIn() : Result<Boolean>
    suspend fun loginKakao(token: String) : Result<Unit>
}