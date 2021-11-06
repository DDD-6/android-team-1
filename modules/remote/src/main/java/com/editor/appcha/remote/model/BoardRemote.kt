package com.editor.appcha.remote.model

import com.editor.appcha.core.arch.model.RemoteModel
import com.editor.appcha.data.model.BoardData
import java.time.LocalDateTime

data class BoardRemote(
    val id: String,
    val title: String,
    val author: String,
    val commentCount: Int,
    val body: String,
    val createdAt: LocalDateTime
) : RemoteModel<BoardData> {

    override fun toData(): BoardData = BoardData(
        id = id,
        title = title,
        author = author,
        commentCount = commentCount,
        body = body,
        createdAt = createdAt
    )
}
