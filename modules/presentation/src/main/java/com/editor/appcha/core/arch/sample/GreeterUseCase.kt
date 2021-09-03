package com.editor.appcha.core.arch.sample

import com.editor.appcha.core.arch.model.DataModel
import com.editor.appcha.core.arch.model.DomainModel
import com.editor.appcha.core.arch.model.RemoteModel
import com.editor.appcha.core.arch.usecase.ResultUseCase
import kotlinx.coroutines.delay

class GreeterUseCase : ResultUseCase<String, Greeter>() {

    override suspend fun execute(param: String): Greeter {
        delay(500L)
        return Greeter("Hello $param")
    }
}

data class GreeterModel(
    val message: String
) {
    companion object {
        operator fun invoke(domain: Greeter): GreeterModel = GreeterModel(domain.message)
    }
}

data class Greeter(
    val message: String
) : DomainModel

data class GreeterData(
    val message: String
) : DataModel<Greeter> {

    override fun toDomain(): Greeter = Greeter(message)
}

data class GreeterRemote(
    val message: String
) : RemoteModel<GreeterData> {

    override fun toData(): GreeterData = GreeterData(message)
}
