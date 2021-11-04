package com.editor.appcha.domain.model

import com.editor.appcha.core.arch.model.DomainModel

data class Profile(
    val nickname: String,
    val imageUrl: String
) : DomainModel