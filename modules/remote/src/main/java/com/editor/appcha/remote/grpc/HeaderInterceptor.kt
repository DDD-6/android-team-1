package com.editor.appcha.remote.grpc

import io.grpc.CallOptions
import io.grpc.Channel
import io.grpc.ClientCall
import io.grpc.ClientInterceptor
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall
import io.grpc.Metadata
import io.grpc.Metadata.Key
import io.grpc.MethodDescriptor

class HeaderInterceptor(
    private val provider: Provider
) : ClientInterceptor {

    fun interface Provider {
        fun get(): Map<String, String>
    }

    override fun <ReqT : Any?, RespT : Any?> interceptCall(
        method: MethodDescriptor<ReqT, RespT>,
        callOptions: CallOptions,
        next: Channel
    ): ClientCall<ReqT, RespT> = object : SimpleForwardingClientCall<ReqT, RespT>(
        next.newCall(method, callOptions)
    ) {
        override fun start(listener: Listener<RespT>, headers: Metadata) {
            provider.get().forEach { (key, value) ->
                headers.put(
                    Key.of(key, Metadata.ASCII_STRING_MARSHALLER),
                    value
                )
            }
            super.start(listener, headers)
        }
    }
}
