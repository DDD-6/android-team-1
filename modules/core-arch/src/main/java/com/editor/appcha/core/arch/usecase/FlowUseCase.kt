package com.editor.appcha.core.arch.usecase

import kotlinx.coroutines.flow.Flow

abstract class FlowUseCase<in P, R> {

    operator fun invoke(param: P): Flow<R> = execute(param)

    protected abstract fun execute(param: P): Flow<R>
}
