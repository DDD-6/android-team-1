package com.editor.appcha.core.arch.mapper

import com.editor.appcha.core.arch.model.DataModel

interface RemoteMapper<T : DataModel<*>> {

    fun toData(): T
}
