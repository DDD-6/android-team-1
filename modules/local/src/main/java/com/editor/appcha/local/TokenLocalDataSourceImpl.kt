package com.editor.appcha.local

import android.content.SharedPreferences
import androidx.core.content.edit
import com.editor.appcha.core.arch.Result
import com.editor.appcha.data.model.TokenData
import com.editor.appcha.data.source.TokenLocalDataSource
import javax.inject.Inject

internal class TokenLocalDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : TokenLocalDataSource {

    override suspend fun getToken(): Result<TokenData> {
        val token = sharedPreferences.getString(KEY_TOKEN, "")
        return Result.success(TokenData(!token.isNullOrEmpty()))
    }

    override suspend fun setToken(token: String): Result<Unit> {
        return Result.success(sharedPreferences.edit {
            putString(KEY_TOKEN, token)
        })
    }

    companion object {
        private const val KEY_TOKEN = "Authorization"
    }
}