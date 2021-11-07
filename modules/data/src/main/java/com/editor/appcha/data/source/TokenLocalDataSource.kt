package com.editor.appcha.data.source

import com.editor.appcha.core.arch.Result

interface TokenLocalDataSource {
    suspend fun getToken() : Result<Boolean>
    suspend fun setToken(accessToken: String) : Result<Unit>
}