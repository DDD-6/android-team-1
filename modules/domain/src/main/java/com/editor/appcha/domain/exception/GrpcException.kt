package com.editor.appcha.domain.exception

import com.editor.appcha.core.arch.model.DomainModel

sealed class GrpcException(
    override val message: String?,
    override val cause: Throwable?
) : Throwable(message, cause),
    DomainModel {

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
}
