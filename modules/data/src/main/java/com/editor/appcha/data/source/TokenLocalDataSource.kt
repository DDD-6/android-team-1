package com.editor.appcha.data.source

import com.editor.appcha.core.arch.Result
import com.editor.appcha.data.model.TokenData

interface TokenLocalDataSource {
    suspend fun getToken() : Result<TokenData>
    suspend fun setToken(token: String) : Result<Unit>
}