package com.editor.appcha.data.repo

import com.editor.appcha.domain.model.User
import com.editor.appcha.domain.repo.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(

) : LoginRepository {

    override fun loginKakao(token: String): Flow<User> {
        //TODO("서버 API 논의")
        return flow {
            emit(User(true, User.Info("")))
        }
    }
}