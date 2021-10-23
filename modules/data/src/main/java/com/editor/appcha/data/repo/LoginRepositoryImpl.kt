package com.editor.appcha.data.repo

import com.editor.appcha.core.arch.Result
import com.editor.appcha.domain.model.User
import com.editor.appcha.domain.repo.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(

) : LoginRepository {

    override suspend fun loginKakao(token: String): Result<User> {
        //TODO("서버 API 논의")
        return Result.success(User(true, User.Profile("")))
    }
}