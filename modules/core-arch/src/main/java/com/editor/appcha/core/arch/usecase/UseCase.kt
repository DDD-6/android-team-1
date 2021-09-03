package com.editor.appcha.core.arch.usecase

import com.editor.appcha.core.arch.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class UseCase<in P, R> {

    operator fun invoke(param: P): Flow<Result<R>> = flow {
        emit(Result.Loading)
        emit(execute(param))
    }

    protected abstract suspend fun execute(param: P): Result<R>
}
