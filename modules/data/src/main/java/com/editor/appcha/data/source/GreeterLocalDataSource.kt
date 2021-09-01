package com.editor.appcha.data.source

interface GreeterLocalDataSource {

    fun getName(): String

    fun saveName(name: String)
}
