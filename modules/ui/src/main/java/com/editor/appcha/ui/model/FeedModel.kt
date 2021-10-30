package com.editor.appcha.ui.model

import com.editor.appcha.domain.model.Feed

data class FeedModel(
    val id: String,
    val title: String,
    val author: String,
    val summary: String,
    val imageUrl: String,
    val apps: List<AppModel>
) {

    companion object {
        operator fun invoke(domain: Feed) = FeedModel(
            id = domain.id,
            title = domain.title,
            author = domain.author,
            summary = domain.summary,
            imageUrl = domain.imageUrl,
            apps = domain.apps.map { AppModel(it) }
        )
    }
}
