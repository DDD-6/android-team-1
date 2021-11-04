package com.editor.appcha.data.repo

import com.editor.appcha.core.arch.Result
import com.editor.appcha.data.model.ProfileData
import com.editor.appcha.data.source.LoginRemoteDataSource
import com.editor.appcha.data.source.TokenLocalDataSource
import com.editor.appcha.domain.model.Profile
import com.editor.appcha.domain.repo.LoginRepository
import javax.inject.Inject

internal class LoginRepositoryImpl @Inject constructor(
    private val tokenLocalDataSource: TokenLocalDataSource,
    private val loginRemoteDataSource: LoginRemoteDataSource
) : LoginRepository {

    override suspend fun isLoggedIn(): Result<Boolean> {
        return tokenLocalDataSource.getToken().map {
            it.isExist
        }
    }

    override suspend fun loginKakao(token: String): Result<Profile> {
        return loginRemoteDataSource
            .login(token)
            .map(ProfileData::toDomain)
    }
}