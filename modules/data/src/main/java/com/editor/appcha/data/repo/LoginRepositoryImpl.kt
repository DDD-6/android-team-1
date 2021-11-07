package com.editor.appcha.data.repo

import com.editor.appcha.core.arch.Result
import com.editor.appcha.data.source.LoginRemoteDataSource
import com.editor.appcha.data.source.TokenLocalDataSource
import com.editor.appcha.domain.repo.LoginRepository
import javax.inject.Inject

internal class LoginRepositoryImpl @Inject constructor(
    private val tokenLocalDataSource: TokenLocalDataSource,
    private val loginRemoteDataSource: LoginRemoteDataSource
) : LoginRepository {

    override suspend fun isLoggedIn(): Result<Boolean> =
        tokenLocalDataSource.getToken()

    override suspend fun loginKakao(token: String): Result<Unit> {
        val accessToken = loginRemoteDataSource.login(token).getOrThrow().accessToken
        return tokenLocalDataSource.setToken(accessToken)
    }
}