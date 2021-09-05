package com.editor.appcha.core.arch.mapper

import com.editor.appcha.core.arch.model.DomainModel

interface DataMapper<T : DomainModel> {

    fun toDomain(): T
}
