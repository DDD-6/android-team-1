package com.editor.appcha.ui.model

import com.editor.appcha.domain.model.App

data class AppModel(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String?,
    val marketUrl: String?
) {

    companion object {

        operator fun invoke(domain: App) = AppModel(
            id = domain.id,
            name = domain.name,
            description = domain.description,
            imageUrl = domain.imageUrl,
            marketUrl = domain.marketUrl
        )
    }
}
