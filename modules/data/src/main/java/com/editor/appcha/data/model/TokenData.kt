package com.editor.appcha.data.model

import com.editor.appcha.core.arch.model.DataModel

data class TokenData(
    val accessToken: String
) : DataModel<Nothing> {

    override fun toDomain(): Nothing {
        TODO("Not yet implemented")
    }
}