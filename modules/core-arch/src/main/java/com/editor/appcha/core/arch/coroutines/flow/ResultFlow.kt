package com.editor.appcha.core.arch.coroutines.flow

import com.editor.appcha.core.arch.Result
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

private class ResultFlow<T>(
    private val loading: Boolean,
    private val block: suspend FlowCollector<T>.() -> Unit
) : Flow<Result<T>> {

    @InternalCoroutinesApi
    override suspend fun collect(collector: FlowCollector<Result<T>>) {
        if (loading) {
            collector.emit(Result.Loading)
        }
        flow(block)
            .catch { throwable -> collector.emit(Result.failure(throwable)) }
            .collect { value -> collector.emit(Result.success(value)) }
    }
}

/**
 * resultFlow<Int> {
 *     emit(5)
 *     emit(10)
 * }
 * -> Result.Loading, Result.success(5), Result.success(10)
 */
fun <T> resultFlow(
    loading: Boolean = true,
    block: suspend FlowCollector<T>.() -> Unit
): Flow<Result<T>> = ResultFlow(loading, block)


/**
 * resultFlowOf<Int>(5, 10) // Result.Loading, Result.success(5), Result.success(10)
 */
fun <T> resultFlowOf(vararg elements: T): Flow<Result<T>> = resultFlow {
    for (element in elements) {
        emit(element)
    }
}

/**
 * flowOf(5, 10).asResultFlow // Result.Loading, Result.success(5), Result.success(10)
 */
fun <T> Flow<T>.asResultFlow(): Flow<Result<T>> = resultFlow {
    collect { value -> emit(value) }
}
