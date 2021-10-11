package com.editor.appcha.remote.model

import com.editor.appcha.core.arch.model.RemoteModel
import com.editor.appcha.data.model.GreeterData

internal data class GreeterRemote(
    val message: String
) : RemoteModel<GreeterData> {

    override fun toData(): GreeterData = GreeterData(message)
}
