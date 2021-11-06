package com.editor.appcha.domain.model

import com.editor.appcha.core.arch.model.DomainModel
import java.time.LocalDateTime

data class Board(
    val id: String,
    val title: String,
    val author: String,
    val commentCount: Int,
    val body: String,
    val createdAt: LocalDateTime
) : DomainModel
