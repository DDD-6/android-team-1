package com.editor.appcha.remote.model

import com.editor.appcha.core.arch.model.RemoteModel
import com.editor.appcha.data.model.ProfileData

data class ProfileRemote(
    val token: String,
    val nickname: String,
    val imageUrl: String
) : RemoteModel<ProfileData> {

    override fun toData(): ProfileData = ProfileData(
        token = token,
        nickname = nickname,
        imageUrl = imageUrl
    )
}
