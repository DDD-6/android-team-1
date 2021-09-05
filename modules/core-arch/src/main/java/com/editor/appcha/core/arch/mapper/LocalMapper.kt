package com.editor.appcha.core.arch.mapper

import com.editor.appcha.core.arch.model.DataModel

interface LocalMapper<T : DataModel<*>> {

    fun toData(): T
}
