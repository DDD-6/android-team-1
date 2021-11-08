package com.editor.appcha.remote.model

import com.editor.appcha.core.arch.model.RemoteModel
import com.editor.appcha.data.model.UserData

data class UserRemote(
    val id: String,
    val profile: ProfileRemote
) : RemoteModel<UserData> {

    data class ProfileRemote(
        val nickname: String,
        val imageUrl: String
    )

    override fun toData(): UserData = UserData(
        id = id,
        nickname = profile.nickname,
        imageUrl = profile.imageUrl
    )
}
