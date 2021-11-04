package com.editor.appcha.remote.source

import com.editor.appcha.core.arch.Result
import com.editor.appcha.data.model.ProfileData
import com.editor.appcha.data.source.LoginRemoteDataSource
import com.editor.appcha.remote.grpc.Grpc
import javax.inject.Inject

internal class LoginRemoteDataSourcesImpl @Inject constructor(
    grpc: Grpc
) : LoginRemoteDataSource {

    //TODO("gRPC 연동")
    override suspend fun login(token: String) : Result<ProfileData> = Result.success(
        ProfileData("AppCha Server Token", "User Nickname", "User Profile Image")
    )
}