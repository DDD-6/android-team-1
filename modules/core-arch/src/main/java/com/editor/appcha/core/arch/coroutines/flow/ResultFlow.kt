package com.editor.appcha.core.arch.coroutines.flow

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.buildResultCatching
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

private class ResultFlow<T>(
    private val block: suspend () -> T
) : Flow<Result<T>> {

    @InternalCoroutinesApi
    override suspend fun collect(collector: FlowCollector<Result<T>>) {
        val result = buildResultCatching { block() }
        collector.emit(result)
    }
}

fun <T> resultFlow(
    block: suspend () -> T
): Flow<Result<T>> = ResultFlow(block)

fun <T> Flow<T>.asResultFlow(): Flow<Result<T>> =
    map { value -> Result.success(value) }
        .catch { throwable -> emit(Result.failure(throwable)) }
