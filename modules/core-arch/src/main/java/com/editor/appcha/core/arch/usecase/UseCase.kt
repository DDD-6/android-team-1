package com.editor.appcha.core.arch.usecase

import com.editor.appcha.core.arch.Result

abstract class UseCase<in P, R> {

    suspend operator fun invoke(param: P): Result<R> = execute(param)

    protected abstract suspend fun execute(param: P): Result<R>
}

suspend operator fun <T> UseCase<Unit, T>.invoke(): Result<T> = invoke(Unit)
