package com.editor.appcha.core.arch.model

import com.editor.appcha.core.arch.mapper.DataMapper

interface DataModel<out T : DomainModel> : DataMapper<T>

inline fun <T : DataModel<R>, R : DomainModel> data(block: () -> T): R = block().toDomain()

inline fun <T : DataModel<R>, R : DomainModel> dataList(block: () -> List<T>): List<R> =
    block().map { it.toDomain() }
