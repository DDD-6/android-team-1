package com.editor.appcha.core.arch.model

import com.editor.appcha.core.arch.mapper.LocalMapper

interface LocalModel<T : DataModel<*>> : LocalMapper<T>

inline fun <T : LocalModel<R>, R : DataModel<*>> buildData(block: () -> T): R = block().toData()

inline fun <T : LocalModel<R>, R : DataModel<*>> buildDataList(block: () -> List<T>): List<R> =
    block().map { it.toData() }
