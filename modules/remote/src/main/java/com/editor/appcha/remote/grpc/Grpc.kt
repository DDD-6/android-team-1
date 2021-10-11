package com.editor.appcha.remote.grpc

import io.grpc.ClientInterceptor
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor

internal class Grpc private constructor(builder: Builder) {

    private val name: String = builder.name.value
    private val port: Int = builder.port.value
    private val interceptors: GrpcClientInterceptors = builder.interceptors

    private fun create(): ManagedChannel = ManagedChannelBuilder.forAddress(name, port)
        .intercept(interceptors)
        .executor(Dispatchers.IO.asExecutor())
        .build()

    suspend fun <T> call(block: suspend (ManagedChannel) -> T): T {
        val channel = create()
        return try {
            block(channel)
        } finally {
            channel.shutdown()
        }
    }

    class Builder(
        val name: GrpcName,
        val port: GrpcPort
    ) {

        var interceptors: GrpcClientInterceptors = GrpcClientInterceptors(emptyList())

        fun intercept(vararg interceptors: ClientInterceptor): Builder = intercept(
            GrpcClientInterceptors(interceptors.toList())
        )

        fun intercept(interceptors: GrpcClientInterceptors): Builder = apply {
            this.interceptors = interceptors
        }

        fun build(): Grpc = Grpc(this)
    }
}
