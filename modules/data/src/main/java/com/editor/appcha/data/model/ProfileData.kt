package com.editor.appcha.data.model

import com.editor.appcha.core.arch.model.DataModel
import com.editor.appcha.domain.model.Profile

data class ProfileData(
    val nickname: String,
    val imageUrl: String
) : DataModel<Profile> {

    override fun toDomain(): Profile = Profile(
        nickname = nickname,
        imageUrl = imageUrl
    )
}