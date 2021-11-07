package com.editor.appcha.remote.model

import com.editor.appcha.core.arch.model.RemoteModel
import com.editor.appcha.data.model.TokenData

data class TokenRemote(
    val accessToken: String
) : RemoteModel<TokenData> {

    override fun toData(): TokenData {
        return TokenData(accessToken)
    }
}