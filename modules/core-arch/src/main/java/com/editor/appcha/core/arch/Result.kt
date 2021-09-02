package com.editor.appcha.core.arch

sealed class Result<out T> {

    data class Success<T> internal constructor(val value: T) : Result<T>()

    data class Failure internal constructor(
        val throwable: Throwable
    ) : Result<Nothing>()

    object Loading : Result<Nothing>() {

        override fun toString(): String = "Loading"
    }

    fun getOrNull(): T? = when (this) {
        is Success -> value
        is Failure,
        Loading -> null
    }

    fun getOrThrow(): T = when (this) {
        is Success -> value
        is Failure -> throw throwable
        Loading -> throw IllegalStateException("Loading could not have any value.")
    }

    fun getOrDefault(default: @UnsafeVariance T): T = when (this) {
        is Success -> value
        is Failure -> default
        Loading -> default
    }

    inline fun onSuccess(action: (value: T) -> Unit): Result<T> {
        if (this is Success) action(value)
        return this
    }

    inline fun onSuccessCatching(action: (value: T) -> Unit): Result<T> =
        try {
            if (this is Success) action(value)
            this
        } catch (e: Throwable) {
            failure(e)
        }

    inline fun onFailure(action: (throwable: Throwable) -> Unit): Result<T> {
        if (this is Failure) action(throwable)
        return this
    }

    inline fun onFailureCatching(action: (throwable: Throwable) -> Unit): Result<T> =
        try {
            if (this is Failure) action(throwable)
            this
        } catch (e: Throwable) {
            failure(e)
        }

    inline fun <R> map(transform: (value: T) -> R): Result<R> =
        when (this) {
            is Success -> success(transform(value))
            is Failure -> this
            Loading -> Loading
        }


    inline fun <R> mapCatching(transform: (value: T) -> R): Result<R> =
        when (this) {
            is Success -> buildResultCatching { transform(value) }
            is Failure -> this
            Loading -> Loading
        }

    inline fun <R> flatMap(transform: (value: T) -> Result<R>): Result<R> =
        when (this) {
            is Success -> transform(value)
            is Failure -> this
            Loading -> Loading
        }

    inline fun <R> flatMapCatching(transform: (value: T) -> Result<R>): Result<R> =
        try {
            when (this) {
                is Success -> transform(value)
                is Failure -> this
                Loading -> Loading
            }
        } catch (e: Throwable) {
            failure(e)
        }

    inline fun recover(
        transform: (throwable: Throwable) -> Result<@UnsafeVariance T>
    ): Result<T> = when (this) {
        is Success -> this
        is Failure -> transform(throwable)
        Loading -> Loading
    }

    inline fun recoverCatching(
        transform: (throwable: Throwable) -> Result<@UnsafeVariance T>
    ): Result<T> = try {
        when (this) {
            is Success -> this
            is Failure -> transform(throwable)
            Loading -> Loading
        }
    } catch (e: Throwable) {
        failure(e)
    }


    companion object {
        fun <T> success(value: T): Result<T> = Success(value)

        fun failure(throwable: Throwable): Result<Nothing> = Failure(throwable)
    }
}

inline fun <T> buildResult(block: () -> T): Result<T> = Result.success(block())

inline fun <T> buildResultCatching(block: () -> T): Result<T> =
    try {
        Result.success(block())
    } catch (e: Throwable) {
        Result.failure(e)
    }
