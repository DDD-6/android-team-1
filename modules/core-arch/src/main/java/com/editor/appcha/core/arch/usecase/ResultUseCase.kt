package com.editor.appcha.core.arch.usecase

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.coroutines.flow.resultFlow
import kotlinx.coroutines.flow.Flow

abstract class ResultUseCase<in P, R> {

    operator fun invoke(param: P): Flow<Result<R>> = resultFlow {
        emit(execute(param))
    }

    protected abstract suspend fun execute(param: P): R
}
