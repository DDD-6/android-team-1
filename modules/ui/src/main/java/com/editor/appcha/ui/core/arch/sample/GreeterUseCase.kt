package com.editor.appcha.ui.core.arch.sample

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.buildResult
import com.editor.appcha.core.arch.model.DataModel
import com.editor.appcha.core.arch.model.DomainModel
import com.editor.appcha.core.arch.model.RemoteModel
import com.editor.appcha.core.arch.model.data
import com.editor.appcha.core.arch.model.remote
import com.editor.appcha.core.arch.usecase.UseCase
import kotlinx.coroutines.delay

class GreeterUseCase : UseCase<String, Greeter>() {

    override suspend fun execute(param: String): Result<Greeter> {
        delay(500L)

        return buildResult {
            data {
                remote {
                    GreeterRemote("Hello $param")
                }
            }
        }
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
