package com.editor.appcha.domain.model

data class User(
    val isExist: Boolean,
    val info: Info
) {

    data class Info(
        val nickname: String
    )
}