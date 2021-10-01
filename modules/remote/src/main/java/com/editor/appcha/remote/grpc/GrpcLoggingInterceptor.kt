package com.editor.appcha.remote.grpc

import com.editor.appcha.remote.grpc.GrpcLoggingInterceptor.Logger.Level.ERROR
import com.editor.appcha.remote.grpc.GrpcLoggingInterceptor.Logger.Level.INFO
import io.grpc.CallOptions
import io.grpc.Channel
import io.grpc.ClientCall
import io.grpc.ClientInterceptor
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.Status
import java.lang.System.currentTimeMillis
import java.text.SimpleDateFormat
import java.util.Locale

class GrpcLoggingInterceptor(
    private val logger: Logger
) : ClientInterceptor {

    fun interface Logger {
        fun log(message: String, level: Level)

        enum class Level {
            INFO,
            ERROR
        }
    }

    override fun <ReqT : Any?, RespT : Any?> interceptCall(
        method: MethodDescriptor<ReqT, RespT>,
        callOptions: CallOptions,
        next: Channel
    ): ClientCall<ReqT, RespT> = object : SimpleForwardingClientCall<ReqT, RespT>(
        next.newCall(method, callOptions)
    ) {
        private val API: String = method.bareMethodName ?: method.fullMethodName

        override fun sendMessage(message: ReqT) {
            logger.log("DATA\n$message", INFO)
            logger.log("--> END", INFO)
            super.sendMessage(message)
        }

        override fun start(responseListener: Listener<RespT>, headers: Metadata) {
            logger.log("--> $API", INFO)
            headers.forEach { k, v -> logger.log("$k: $v", INFO) }
            val listener = object : SimpleForwardingClientCallListener<RespT>(responseListener) {
                override fun onMessage(message: RespT) {
                    logger.log("<-- $API", INFO)
                    logger.log("Date: ${now()}", INFO)
                    logger.log(convertOctalToString(message), INFO)
                    super.onMessage(message)
                }

                override fun onClose(status: Status, trailers: Metadata) {
                    val level = if (status.isOk) INFO else ERROR
                    logger.log("status: ${status.code.value()} ${status.code}", level)
                    if (!status.isOk) {
                        status.cause?.let { logger.log("cause: $it", level) }
                        logger.log("description: ${status.description}", level)
                    }
                    logger.log("<-- END $API", INFO)
                    super.onClose(status, trailers)
                }
            }
            super.start(listener, headers)
        }
    }

    /**
     * https://stackoverflow.com/questions/52464580/converting-string-consisting-of-octal-numbers-to-utf-8-text
     */
    private fun <RespT> convertOctalToString(text: RespT): String =
        OCTAL_REGEX.toRegex().replace(text.toString()) { matchResult ->
            matchResult.value.drop(1)
                .split("\\")
                .map { it.toInt(8).toByte() }
                .toByteArray()
                .toString(Charsets.UTF_8)
        }

    private inline fun Metadata.forEach(action: (String, String?) -> Unit): Unit =
        keys().forEach { k ->
            val value = get(Metadata.Key.of(k, Metadata.ASCII_STRING_MARSHALLER))
            action(k, value)
        }

    companion object {
        private const val OCTAL_REGEX = """(\\\d{3})+"""
        private const val PATTERN_DATE = "EEE, d MMM yyyy HH:mm:ss"

        private fun now(): String =
            SimpleDateFormat(PATTERN_DATE, Locale.getDefault()).format(currentTimeMillis())
    }
}
