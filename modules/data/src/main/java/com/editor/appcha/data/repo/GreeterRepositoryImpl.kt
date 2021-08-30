package com.editor.appcha.data.repo

import com.editor.appcha.data.source.GreeterRemoteDataSource
import com.editor.appcha.domain.model.Greeter
import com.editor.appcha.domain.repo.GreeterRepository

internal class GreeterRepositoryImpl(
    private val source: GreeterRemoteDataSource
) : GreeterRepository {

    override fun sayHello(name: String): Greeter {
        val message = source.sayHello(name).message
        return Greeter(message = message)
    }
}
