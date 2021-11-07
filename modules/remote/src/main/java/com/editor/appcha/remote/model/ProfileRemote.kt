package com.editor.appcha.remote.model

import com.editor.appcha.core.arch.model.RemoteModel
import com.editor.appcha.data.model.ProfileData

data class ProfileRemote(
    val nickname: String,
    val imageUrl: String
) : RemoteModel<ProfileData> {

    override fun toData(): ProfileData = ProfileData(
        nickname = nickname,
        imageUrl = imageUrl
    )
}
