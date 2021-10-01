package com.editor.appcha.remote.grpc

import io.grpc.ClientInterceptor

class ClientInterceptors(val interceptors: List<ClientInterceptor>)
