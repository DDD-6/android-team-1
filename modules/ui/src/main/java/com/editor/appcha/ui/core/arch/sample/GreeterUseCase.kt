package com.editor.appcha.ui.core.arch.sample

import com.editor.appcha.core.arch.model.DataModel
import com.editor.appcha.core.arch.model.DomainModel
import com.editor.appcha.core.arch.model.RemoteModel
import com.editor.appcha.core.arch.model.data
import com.editor.appcha.core.arch.model.remote
import com.editor.appcha.core.arch.usecase.FlowUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GreeterUseCase : FlowUseCase<String, Greeter>() {

    override fun execute(param: String): Flow<Greeter> = flow {
        delay(500L)

        val result = data {
            remote {
                GreeterRemote("Hello $param")
            }
        }
        emit(result)
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
