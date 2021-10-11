package com.editor.appcha.core.arch.mapper

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.model.DataModel
import com.editor.appcha.core.arch.model.DomainModel

interface DataMapper<out T : DomainModel> {

    fun toDomain(): T
}

fun <T : DomainModel> Result<DataModel<T>>.toDomain(): Result<T> =
    when (this) {
        is Result.Success -> Result.success(value.toDomain())
        is Result.Failure -> Result.failure(
            if (throwable is DataModel<*>) {
                (throwable.toDomain() as? Throwable) ?: throwable
            } else {
                throwable
            }
        )
    }
