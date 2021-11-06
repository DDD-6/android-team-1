package com.editor.appcha.remote.model.request

import com.editor.appcha.data.model.request.PostCommentData

data class PostCommentRequest(
    val boardId: String,
    val text: String,
) {

    companion object {
        operator fun invoke(data: PostCommentData) = PostCommentRequest(
            boardId = data.boardId,
            text = data.text
        )
    }
}
