package com.editor.appcha.remote.grpc

import io.grpc.ClientInterceptor

class GrpcClientInterceptors(
    private val interceptors: List<ClientInterceptor>
) : List<ClientInterceptor> by interceptors
