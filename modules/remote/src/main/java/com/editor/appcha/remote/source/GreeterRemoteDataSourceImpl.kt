package com.editor.appcha.remote.source

import com.editor.appcha.data.model.GreeterData
import com.editor.appcha.data.source.GreeterRemoteDataSource
import com.editor.appcha.grpc.GreeterServiceGrpcKt.GreeterServiceCoroutineStub
import com.editor.appcha.remote.grpc.Grpc
import com.editor.appcha.remote.grpc.GrpcClient
import com.editor.appcha.remote.model.GreeterRemote
import io.grpc.ManagedChannel
import javax.inject.Inject

internal class GreeterRemoteDataSourceImpl @Inject constructor(
    grpc: Grpc
) : GrpcClient<GreeterServiceCoroutineStub>(grpc), GreeterRemoteDataSource {

    override fun stub(channel: ManagedChannel): GreeterServiceCoroutineStub =
        GreeterServiceCoroutineStub(channel)

    override suspend fun sayHello(name: String): GreeterData = runGrpc { stub ->
        val response = GreeterRemote("Hello $name")
        GreeterData(response.message)
    }.getOrDefault(GreeterData(""))
}
