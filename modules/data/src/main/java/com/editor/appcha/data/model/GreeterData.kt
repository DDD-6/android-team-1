package com.editor.appcha.data.model

import com.editor.appcha.core.arch.model.DataModel
import com.editor.appcha.domain.model.Greeter

data class GreeterData(
    val message: String
) : DataModel<Greeter> {

    override fun toDomain(): Greeter = Greeter(message)
}
