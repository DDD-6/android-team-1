package com.editor.appcha.domain.model

import com.editor.appcha.core.arch.model.DomainModel
import java.time.LocalDateTime

data class Comment(
    val boardId: String,
    val author: String,
    val text: String,
    val createdAt: LocalDateTime
) : DomainModel
