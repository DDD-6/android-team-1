package com.editor.appcha.domain.repo

import com.editor.appcha.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun loginKakao(token: String) : Flow<User>
}