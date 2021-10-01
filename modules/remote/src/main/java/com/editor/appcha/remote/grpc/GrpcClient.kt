package com.editor.appcha.remote.grpc

import io.grpc.ManagedChannel
import io.grpc.kotlin.AbstractCoroutineStub

abstract class GrpcClient<T : AbstractCoroutineStub<T>>(
    protected val grpc: Grpc
) {

    protected abstract fun stub(channel: ManagedChannel): T

    protected suspend fun <R> runGrpc(
        block: suspend (stub: T) -> R
    ): Result<R> = grpc.call { channel ->
        val stub = stub(channel)
        runCatching { block(stub) }
    }.recoverCatching { throwable ->
        throw throwable.asStatus()
            ?.asGrpcException()
            ?: throwable
    }
}
