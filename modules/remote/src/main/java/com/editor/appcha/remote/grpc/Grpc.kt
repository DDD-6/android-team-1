package com.editor.appcha.remote.grpc

import io.grpc.ClientInterceptor
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor

class Grpc private constructor(builder: Builder) {

    private val name: String = builder.name.value
    private val port: Int = builder.port.value
    private val interceptors: ClientInterceptors = builder.interceptors

    private fun create(): ManagedChannel = ManagedChannelBuilder.forAddress(name, port)
        .intercept(interceptors.interceptors)
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

        var interceptors: ClientInterceptors = ClientInterceptors(emptyList())

        fun intercept(vararg interceptors: ClientInterceptor): Builder = intercept(
            ClientInterceptors(interceptors.toList())
        )

        fun intercept(interceptors: ClientInterceptors): Builder = apply {
            this.interceptors = interceptors
        }

        fun build(): Grpc = Grpc(this)
    }
}
