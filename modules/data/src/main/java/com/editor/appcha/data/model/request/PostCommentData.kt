package com.editor.appcha.data.model.request

import com.editor.appcha.domain.model.request.PostComment

data class PostCommentData(
    val boardId: String,
    val text: String,
) {

    companion object {
        operator fun invoke(domain: PostComment) = PostCommentData(
            boardId = domain.boardId,
            text = domain.text
        )
    }
}
