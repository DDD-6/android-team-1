package com.editor.appcha.local

import android.content.SharedPreferences
import androidx.core.content.edit
import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.buildResultCatching
import com.editor.appcha.data.source.TokenLocalDataSource
import javax.inject.Inject

internal class TokenLocalDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : TokenLocalDataSource {

    override suspend fun isTokenExist(): Result<Boolean> {
        val token = sharedPreferences.getString(KEY_TOKEN, "")
        return Result.success(!token.isNullOrEmpty())
    }

    override suspend fun setToken(accessToken: String): Result<Unit> = buildResultCatching {
        sharedPreferences.edit() {
            putString(KEY_TOKEN, accessToken)
        }
    }

    companion object {
        private const val KEY_TOKEN = "Authorization"
    }
}