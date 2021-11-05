package com.editor.appcha.domain.model

import com.editor.appcha.core.arch.model.DomainModel

data class FeedDetail(
    val id: String,
    val title: String,
    val author: String,
    val bodies: List<Body>,
    val isFavorite: Boolean
) : DomainModel {

    sealed class Body {

        data class Text(val text: String) : Body()

        data class Image(val imageUrl: String) : Body()

        data class Apps(val apps: List<App>) : Body()
    }
}
