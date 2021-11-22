package com.editor.appcha.ui.model

import com.editor.appcha.domain.model.Comment
import java.time.LocalDateTime

data class CommentModel(
    val boardId: String,
    val author: String,
    val text: String,
    val createdAt: LocalDateTime
) {

    companion object {
        operator fun invoke(domain: Comment) = CommentModel(
            boardId = domain.boardId,
            author = domain.author,
            text = domain.text,
            createdAt = domain.createdAt
        )
    }
}
