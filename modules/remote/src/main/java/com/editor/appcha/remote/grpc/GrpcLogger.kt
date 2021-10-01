package com.editor.appcha.remote.grpc

fun interface GrpcLogger {
    fun log(message: String, level: Level)

    enum class Level {
        INFO,
        ERROR
    }
}
