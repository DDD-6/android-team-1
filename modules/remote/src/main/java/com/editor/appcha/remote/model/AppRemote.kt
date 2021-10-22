package com.editor.appcha.remote.model

import com.editor.appcha.core.arch.model.RemoteModel
import com.editor.appcha.data.model.AppData

data class AppRemote(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String?,
    val marketUrl: String?
) : RemoteModel<AppData> {

    override fun toData(): AppData = AppData(
        id = id,
        name = name,
        description = description,
        imageUrl = imageUrl,
        marketUrl = marketUrl
    )
}
