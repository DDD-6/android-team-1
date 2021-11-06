package com.editor.appcha.data.model

import com.editor.appcha.core.arch.model.DataModel
import com.editor.appcha.domain.model.Board
import java.time.LocalDateTime

data class BoardData(
    val id: String,
    val title: String,
    val author: String,
    val commentCount: Int,
    val body: String,
    val createdAt: LocalDateTime
) : DataModel<Board> {

    override fun toDomain(): Board = Board(
        id = id,
        title = title,
        author = author,
        commentCount = commentCount,
        body = body,
        createdAt = createdAt
    )
}
