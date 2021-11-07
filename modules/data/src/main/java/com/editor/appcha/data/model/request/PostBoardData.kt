package com.editor.appcha.data.model.request

import com.editor.appcha.domain.model.request.PostBoard

data class PostBoardData(
    val title: String,
    val body: String
) {

    companion object {

        operator fun invoke(domain: PostBoard) = PostBoardData(
            title = domain.title,
            body = domain.body
        )
    }
}
