package com.editor.appcha.data.source

import com.editor.appcha.core.arch.Result
import com.editor.appcha.data.model.ProfileData

interface LoginRemoteDataSource {
    suspend fun login(token: String) : Result<ProfileData>
}