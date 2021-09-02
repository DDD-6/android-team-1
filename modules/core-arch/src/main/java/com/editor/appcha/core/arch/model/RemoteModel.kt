package com.editor.appcha.core.arch.model

import com.editor.appcha.core.arch.mapper.RemoteMapper

interface RemoteModel<T : DataModel<*>> : RemoteMapper<T>

inline fun <T : RemoteModel<R>, R : DataModel<*>> buildData(block: () -> T): R = block().toData()

inline fun <T : RemoteModel<R>, R : DataModel<*>> buildDataList(block: () -> List<T>): List<R> =
    block().map { it.toData() }
