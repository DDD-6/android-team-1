package com.editor.appcha.remote.grpc

import io.grpc.Status
import io.grpc.StatusException
import io.grpc.StatusRuntimeException

internal fun Throwable.asStatus(): Status? =
    (this as? StatusException)?.status ?: (this as? StatusRuntimeException)?.status

internal fun Status.asGrpcException(): GrpcException = when (code) {
    Status.Code.CANCELLED -> GrpcException.Cancelled(description, cause)
    Status.Code.UNKNOWN -> GrpcException.Unknown(description, cause)
    Status.Code.INVALID_ARGUMENT -> GrpcException.InvalidArgument(description, cause)
    Status.Code.DEADLINE_EXCEEDED -> GrpcException.DeadlineExceeded(description, cause)
    Status.Code.NOT_FOUND -> GrpcException.NotFound(description, cause)
    Status.Code.ALREADY_EXISTS -> GrpcException.AlreadyExists(description, cause)
    Status.Code.PERMISSION_DENIED -> GrpcException.PermissionDenied(description, cause)
    Status.Code.RESOURCE_EXHAUSTED -> GrpcException.ResourceExhausted(description, cause)
    Status.Code.FAILED_PRECONDITION -> GrpcException.FailedPreCondition(description, cause)
    Status.Code.ABORTED -> GrpcException.Aborted(description, cause)
    Status.Code.OUT_OF_RANGE -> GrpcException.OutOfRange(description, cause)
    Status.Code.UNIMPLEMENTED -> GrpcException.UnImplemented(description, cause)
    Status.Code.INTERNAL -> GrpcException.Internal(description, cause)
    Status.Code.UNAVAILABLE -> GrpcException.Unavailable(description, cause)
    Status.Code.DATA_LOSS -> GrpcException.DataLoss(description, cause)
    Status.Code.UNAUTHENTICATED -> GrpcException.Unauthenticated(description, cause)
    else -> GrpcException.Unknown(description, cause)
}
