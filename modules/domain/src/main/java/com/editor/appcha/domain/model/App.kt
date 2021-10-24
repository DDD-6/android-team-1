package com.editor.appcha.domain.model

import com.editor.appcha.core.arch.model.DomainModel

data class App(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String?,
    val marketUrl: String?
) : DomainModel
