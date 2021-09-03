package com.editor.appcha.core.arch.usecase

import com.editor.appcha.core.arch.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

abstract class FlowUseCase<in P, R> {

    operator fun invoke(param: P): Flow<Result<R>> = flow {
        emit(Result.Loading)
        execute(param)
            .catch { throwable -> emit(Result.failure(throwable)) }
            .collect { value -> emit(Result.success(value)) }
    }

    protected abstract fun execute(param: P): Flow<R>
}
