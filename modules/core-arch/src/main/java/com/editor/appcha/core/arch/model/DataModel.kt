package com.editor.appcha.core.arch.model

import com.editor.appcha.core.arch.mapper.DataMapper

interface DataModel<T : DomainModel> : DataMapper<T>

inline fun <T : DataModel<R>, R : DomainModel> buildDomain(block: () -> T): R = block().toDomain()

inline fun <T : DataModel<R>, R : DomainModel> buildDomainList(block: () -> List<T>): List<R> =
    block().map { it.toDomain() }
