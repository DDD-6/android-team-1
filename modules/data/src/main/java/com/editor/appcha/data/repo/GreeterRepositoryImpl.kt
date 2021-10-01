package com.editor.appcha.data.repo

import com.editor.appcha.data.source.GreeterLocalDataSource
import com.editor.appcha.data.source.GreeterRemoteDataSource
import com.editor.appcha.domain.model.Greeter
import com.editor.appcha.domain.repo.GreeterRepository
import javax.inject.Inject

internal class GreeterRepositoryImpl @Inject constructor(
    private val local: GreeterLocalDataSource,
    private val remote: GreeterRemoteDataSource
) : GreeterRepository {

    override fun getName(): String = local.getName()

    override suspend fun sayHello(name: String): Greeter {
        val message = remote.sayHello(name).message
        return Greeter(message = message)
    }
}
