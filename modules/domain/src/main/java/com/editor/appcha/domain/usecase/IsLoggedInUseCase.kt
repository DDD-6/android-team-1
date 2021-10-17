package com.editor.appcha.domain.usecase

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.usecase.UseCase
import javax.inject.Inject

class IsLoggedInUseCase @Inject constructor(

) : UseCase<Unit, Boolean>() {

    /**
     * TODO: 데이터 소스로부터 로그인 여부 판단하기
     */
    override suspend fun execute(param: Unit): Result<Boolean> = Result.success(true)
}
