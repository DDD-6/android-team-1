package com.editor.appcha.domain.model

import com.editor.appcha.core.arch.model.DomainModel

data class Feed(
    val id: String,
    val title: String,
    val author: String,
    val summary: String,
    val apps: List<App>
) : DomainModel
