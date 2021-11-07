package com.editor.appcha.ui.model

import com.editor.appcha.domain.model.FeedDetail

data class FeedDetailModel(
    val id: String,
    val title: String,
    val author: String,
    val imageUrl: String,
    val summary: String,
    val bodies: List<Body>,
    val isFavorite: Boolean
) {

    sealed class Body {

        data class Text(val text: String) : Body()

        data class Image(val imageUrl: String) : Body()

        data class Apps(val apps: List<AppModel>) : Body()
    }

    companion object {

        operator fun invoke(domain: FeedDetail): FeedDetailModel = FeedDetailModel(
            id = domain.id,
            title = domain.title,
            author = domain.author,
            imageUrl = domain.imageUrl,
            summary = domain.summary,
            bodies = domain.bodies.map { body ->
                when (body) {
                    is FeedDetail.Body.Text -> Body.Text(body.text)
                    is FeedDetail.Body.Image -> Body.Image(body.imageUrl)
                    is FeedDetail.Body.Apps -> Body.Apps(body.apps.map { AppModel(it) })
                }
            },
            isFavorite = domain.isFavorite
        )
    }
}
