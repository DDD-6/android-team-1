package com.editor.appcha.local.source

import com.editor.appcha.data.source.GreeterLocalDataSource

private var nameCache: String? = null

internal class GreeterLocalDataSourceImpl : GreeterLocalDataSource {

    override fun getName(): String = nameCache ?: ""

    override fun saveName(name: String) {
        nameCache = name
    }
}
