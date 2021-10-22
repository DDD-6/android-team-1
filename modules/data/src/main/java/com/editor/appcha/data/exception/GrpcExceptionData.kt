package com.editor.appcha.data.exception

import com.editor.appcha.core.arch.model.DataModel
import com.editor.appcha.domain.exception.GrpcException

/**
 * @see [io.grpc.Status.Code]
 */
sealed class GrpcExceptionData(
    override val message: String?,
    override val cause: Throwable?
) : Throwable(message, cause),
    DataModel<GrpcException> {

    data class Cancelled(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcExceptionData(message, cause)

    data class Unknown(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcExceptionData(message, cause)

    data class InvalidArgument(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcExceptionData(message, cause)

    data class DeadlineExceeded(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcExceptionData(message, cause)

    data class NotFound(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcExceptionData(message, cause)

    data class AlreadyExists(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcExceptionData(message, cause)

    data class PermissionDenied(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcExceptionData(message, cause)

    data class ResourceExhausted(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcExceptionData(message, cause)

    data class FailedPreCondition(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcExceptionData(message, cause)

    data class Aborted(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcExceptionData(message, cause)

    data class OutOfRange(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcExceptionData(message, cause)

    data class UnImplemented(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcExceptionData(message, cause)

    data class Internal(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcExceptionData(message, cause)

    data class Unavailable(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcExceptionData(message, cause)

    data class DataLoss(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcExceptionData(message, cause)

    data class Unauthenticated(
        override val message: String?,
        override val cause: Throwable?
    ) : GrpcExceptionData(message, cause)

    override fun toDomain(): GrpcException = when (this) {
        is Aborted -> GrpcException.Aborted(message, cause)
        is AlreadyExists -> GrpcException.AlreadyExists(message, cause)
        is Cancelled -> GrpcException.Cancelled(message, cause)
        is DataLoss -> GrpcException.DataLoss(message, cause)
        is DeadlineExceeded -> GrpcException.DeadlineExceeded(message, cause)
        is FailedPreCondition -> GrpcException.FailedPreCondition(message, cause)
        is Internal -> GrpcException.Internal(message, cause)
        is InvalidArgument -> GrpcException.InvalidArgument(message, cause)
        is NotFound -> GrpcException.NotFound(message, cause)
        is OutOfRange -> GrpcException.OutOfRange(message, cause)
        is PermissionDenied -> GrpcException.PermissionDenied(message, cause)
        is ResourceExhausted -> GrpcException.ResourceExhausted(message, cause)
        is UnImplemented -> GrpcException.UnImplemented(message, cause)
        is Unauthenticated -> GrpcException.Unauthenticated(message, cause)
        is Unavailable -> GrpcException.Unavailable(message, cause)
        is Unknown -> GrpcException.Unknown(message, cause)
    }
}
