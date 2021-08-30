package com.editor.appcha.domain.repo

import com.editor.appcha.domain.model.Greeter

interface GreeterRepository {

    fun sayHello(name: String): Greeter
}
