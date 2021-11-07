package com.editor.appcha.remote.source

import com.editor.appcha.core.arch.Result
import com.editor.appcha.data.model.TokenData
import com.editor.appcha.data.source.LoginRemoteDataSource
import com.editor.appcha.remote.grpc.Grpc
import com.editor.appcha.remote.model.TokenRemote
import javax.inject.Inject

internal class LoginRemoteDataSourcesImpl @Inject constructor(
    grpc: Grpc
) : LoginRemoteDataSource {

    //TODO("gRPC 연동")
    override suspend fun login(token: String) : Result<TokenData> = Result.success(
        TokenRemote("appcha-server-accesstoken").toData()
    )
}