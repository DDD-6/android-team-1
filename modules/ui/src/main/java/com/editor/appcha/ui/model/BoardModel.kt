package com.editor.appcha.ui.model

import com.editor.appcha.domain.model.Board
import java.time.LocalDateTime

data class BoardModel(
    val id: String,
    val title: String,
    val author: String,
    val commentCount: Int,
    val body: String,
    val createdAt: LocalDateTime
) {

    companion object {
        operator fun invoke(domain: Board) = BoardModel(
            id = domain.id,
            title = domain.title,
            author = domain.author,
            commentCount = domain.commentCount,
            body = domain.body,
            createdAt = domain.createdAt
        )
    }
}
