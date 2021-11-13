package com.editor.appcha.data.model

import com.editor.appcha.core.arch.model.DataModel
import com.editor.appcha.domain.model.User

data class UserData(
    val id: String,
    val nickname: String,
    val imageUrl: String
) : DataModel<User> {

    override fun toDomain(): User = User(
        id = id,
        nickname = nickname,
        imageUrl = imageUrl
    )
}