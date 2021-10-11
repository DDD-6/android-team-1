package com.editor.appcha.core.arch.model

import com.editor.appcha.core.arch.mapper.RemoteMapper

interface RemoteModel<out T : DataModel<*>> : RemoteMapper<T>

inline fun <T : RemoteModel<R>, R : DataModel<*>> remote(block: () -> T): R = block().toData()

inline fun <T : RemoteModel<R>, R : DataModel<*>> remoteList(block: () -> List<T>): List<R> =
    block().map { it.toData() }

