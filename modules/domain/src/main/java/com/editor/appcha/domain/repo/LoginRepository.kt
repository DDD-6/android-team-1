package com.editor.appcha.domain.repo

import com.editor.appcha.core.arch.Result

interface LoginRepository {
    suspend fun isLoggedIn() : Result<Boolean>
    suspend fun loginKakao(token: String) : Result<Unit>
}