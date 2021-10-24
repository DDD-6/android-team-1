package com.editor.appcha.data.model

import com.editor.appcha.core.arch.model.DataModel
import com.editor.appcha.domain.model.App

data class AppData(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String?,
    val marketUrl: String?
) : DataModel<App> {

    override fun toDomain(): App = App(
        id = id,
        name = name,
        description = description,
        imageUrl = imageUrl,
        marketUrl = marketUrl
    )
}
