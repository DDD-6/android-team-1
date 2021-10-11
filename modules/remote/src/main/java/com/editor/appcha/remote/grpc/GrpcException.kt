package com.editor.appcha.remote.grpc

import com.editor.appcha.core.arch.model.RemoteModel
import com.editor.appcha.data.exception.GrpcExceptionData

/**
 * @see [io.grpc.Status.Code]
 */
internal sealed class GrpcException(
    override val message: String?,
    override val cause: Throwable?
) : Throwable(message, cause),
    RemoteModel<GrpcExceptionData> {

    data class Cancelled(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcException(message, cause)

    data class Unknown(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcException(message, cause)

    data class InvalidArgument(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcException(message, cause)

    data class DeadlineExceeded(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcException(message, cause)

    data class NotFound(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcException(message, cause)

    data class AlreadyExists(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcException(message, cause)

    data class PermissionDenied(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcException(message, cause)

    data class ResourceExhausted(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcException(message, cause)

    data class FailedPreCondition(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcException(message, cause)

    data class Aborted(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcException(message, cause)

    data class OutOfRange(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcException(message, cause)

    data class UnImplemented(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcException(message, cause)

    data class Internal(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcException(message, cause)

    data class Unavailable(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcException(message, cause)

    data class DataLoss(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcException(message, cause)

    data class Unauthenticated(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcException(message, cause)

    override fun toData(): GrpcExceptionData = when (this) {
        is Aborted -> GrpcExceptionData.Aborted(message, cause)
        is AlreadyExists -> GrpcExceptionData.AlreadyExists(message, cause)
        is Cancelled -> GrpcExceptionData.Cancelled(message, cause)
        is DataLoss -> GrpcExceptionData.DataLoss(message, cause)
        is DeadlineExceeded -> GrpcExceptionData.DeadlineExceeded(message, cause)
        is FailedPreCondition -> GrpcExceptionData.FailedPreCondition(message, cause)
        is Internal -> GrpcExceptionData.Internal(message, cause)
        is InvalidArgument -> GrpcExceptionData.InvalidArgument(message, cause)
        is NotFound -> GrpcExceptionData.NotFound(message, cause)
        is OutOfRange -> GrpcExceptionData.OutOfRange(message, cause)
        is PermissionDenied -> GrpcExceptionData.PermissionDenied(message, cause)
        is ResourceExhausted -> GrpcExceptionData.ResourceExhausted(message, cause)
        is UnImplemented -> GrpcExceptionData.UnImplemented(message, cause)
        is Unauthenticated -> GrpcExceptionData.Unauthenticated(message, cause)
        is Unavailable -> GrpcExceptionData.Unavailable(message, cause)
        is Unknown -> GrpcExceptionData.Unknown(message, cause)
    }
}
