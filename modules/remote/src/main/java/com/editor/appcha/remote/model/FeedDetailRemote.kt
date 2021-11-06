package com.editor.appcha.remote.model

import com.editor.appcha.core.arch.model.RemoteModel
import com.editor.appcha.data.model.FeedDetailData

data class FeedDetailRemote(
    val id: String,
    val title: String,
    val author: String,
    val imageUrl: String,
    val bodies: List<Body>,
    val isFavorite: Boolean
) : RemoteModel<FeedDetailData> {

    sealed class Body {

        data class Text(val text: String) : Body()

        data class Image(val imageUrl: String) : Body()

        data class Apps(val apps: List<AppRemote>) : Body()
    }

    override fun toData(): FeedDetailData = FeedDetailData(
        id = id,
        title = title,
        author = author,
        imageUrl = imageUrl,
        bodies = bodies.map { body ->
            when (body) {
                is Body.Text -> FeedDetailData.Body.Text(body.text)
                is Body.Image -> FeedDetailData.Body.Image(body.imageUrl)
                is Body.Apps -> FeedDetailData.Body.Apps(body.apps.map { it.toData() })
            }
        },
        isFavorite = isFavorite
    )
}
