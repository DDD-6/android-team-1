package com.editor.appcha.remote.model

import com.editor.appcha.core.arch.model.RemoteModel
import com.editor.appcha.data.model.CommentData
import java.time.LocalDateTime

data class CommentRemote(
    val boardId: String,
    val author: String,
    val text: String,
    val createdAt: LocalDateTime
) : RemoteModel<CommentData> {

    override fun toData(): CommentData = CommentData(
        boardId = boardId,
        author = author,
        text = text,
        createdAt = createdAt
    )
}
