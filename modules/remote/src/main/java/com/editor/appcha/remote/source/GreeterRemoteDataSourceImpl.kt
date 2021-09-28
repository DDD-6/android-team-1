package com.editor.appcha.remote.source

import com.editor.appcha.data.model.GreeterData
import com.editor.appcha.data.source.GreeterRemoteDataSource
import com.editor.appcha.remote.model.GreeterRemote
import javax.inject.Inject

internal class GreeterRemoteDataSourceImpl @Inject constructor(
    // TODO: grpc
) : GreeterRemoteDataSource {

    override fun sayHello(name: String): GreeterData {
        val response = GreeterRemote("Hello $name")
        return GreeterData(response.message)
    }
}
