package com.editor.appcha.domain.model

data class User(
    val isExist: Boolean,
    val info: Profile
) {

    data class Profile(
        val nickname: String
    )
}