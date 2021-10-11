package com.editor.appcha.core.arch.mapper

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.model.DataModel
import com.editor.appcha.core.arch.model.RemoteModel

interface RemoteMapper<out T : DataModel<*>> {

    fun toData(): T
}

fun <T : DataModel<*>> Result<RemoteModel<T>>.toData(): Result<T> =
    when (this) {
        is Result.Success -> Result.success(value.toData())
        is Result.Failure -> Result.failure(
            if (throwable is RemoteModel<*>) {
                (throwable.toData() as? Throwable) ?: throwable
            } else {
                throwable
            }
        )
    }
