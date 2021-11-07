package com.editor.appcha.data.model

import com.editor.appcha.core.arch.model.DataModel
import com.editor.appcha.domain.model.Comment
import java.time.LocalDateTime

data class CommentData(
    val boardId: String,
    val author: String,
    val text: String,
    val createdAt: LocalDateTime
) : DataModel<Comment> {

    override fun toDomain(): Comment = Comment(
        boardId = boardId,
        author = author,
        text = text,
        createdAt = createdAt
    )
}
