package com.editor.appcha.remote.grpc

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.buildResultCatching
import io.grpc.ManagedChannel
import io.grpc.kotlin.AbstractCoroutineStub

internal abstract class GrpcClient<T : AbstractCoroutineStub<T>>(
    protected val grpc: Grpc
) {

    protected abstract fun stub(channel: ManagedChannel): T

    protected suspend fun <R> runGrpc(
        block: suspend (stub: T) -> R
    ): Result<R> = grpc.call { channel ->
        val stub = stub(channel)
        buildResultCatching { block(stub) }
    }.recoverCatching { throwable ->
        Result.failure(
            throwable.asStatus()
                ?.asGrpcException()
                ?: throwable
        )
    }
}
