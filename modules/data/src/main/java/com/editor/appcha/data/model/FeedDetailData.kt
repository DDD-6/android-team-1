package com.editor.appcha.data.model

import com.editor.appcha.core.arch.model.DataModel
import com.editor.appcha.domain.model.FeedDetail

data class FeedDetailData(
    val id: String,
    val title: String,
    val author: String,
    val imageUrl: String,
    val summary: String,
    val bodies: List<Body>,
    val isFavorite: Boolean
) : DataModel<FeedDetail> {

    sealed class Body {

        data class Text(val text: String) : Body()

        data class Image(val imageUrl: String) : Body()

        data class Apps(val apps: List<AppData>) : Body()
    }

    override fun toDomain(): FeedDetail = FeedDetail(
        id = id,
        title = title,
        author = author,
        imageUrl = imageUrl,
        summary = summary,
        bodies = bodies.map { body ->
            when (body) {
                is Body.Text -> FeedDetail.Body.Text(body.text)
                is Body.Image -> FeedDetail.Body.Image(body.imageUrl)
                is Body.Apps -> FeedDetail.Body.Apps(body.apps.map { it.toDomain() })
            }
        },
        isFavorite = isFavorite
    )
}
