package com.editor.appcha.local.source

import com.editor.appcha.data.source.GreeterLocalDataSource
import javax.inject.Inject

private var nameCache: String? = null

internal class GreeterLocalDataSourceImpl @Inject constructor() : GreeterLocalDataSource {

    override fun getName(): String = nameCache ?: ""

    override fun saveName(name: String) {
        nameCache = name
    }
}
