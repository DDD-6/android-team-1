package com.editor.appcha.core.arch.mapper

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.model.DataModel
import com.editor.appcha.core.arch.model.LocalModel

interface LocalMapper<T : DataModel<*>> {

    fun toData(): T
}

fun <T : DataModel<*>> Result<LocalModel<T>>.toData(): Result<T> =
    when (this) {
        is Result.Success -> Result.success(value.toData())
        is Result.Failure -> Result.failure(
            if (throwable is LocalModel<*>) {
                (throwable.toData() as? Throwable) ?: throwable
            } else {
                throwable
            }
        )
    }
