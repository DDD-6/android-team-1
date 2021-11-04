package com.editor.appcha.di

import android.content.SharedPreferences
import android.util.Log
import com.editor.appcha.remote.grpc.GrpcClientInterceptors
import com.editor.appcha.remote.grpc.GrpcHeaderInterceptor
import com.editor.appcha.remote.grpc.GrpcLoggingInterceptor
import com.editor.appcha.remote.grpc.GrpcLoggingInterceptor.Logger.Level
import com.editor.appcha.remote.grpc.GrpcName
import com.editor.appcha.remote.grpc.GrpcPort
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object GrpcModule {

    private const val TAG = "GRPC"
    private const val HEADER_KEY_AUTHORIZATION = "Authorization"

    @Provides
    fun provideGrpcName(): GrpcName = GrpcName("localhost")

    @Provides
    fun provideGrpcPort(): GrpcPort = GrpcPort(8888)

    @Provides
    fun provideGrpcClientInterceptors(
        sharedPreferences: SharedPreferences
    ): GrpcClientInterceptors {
        val interceptors = listOf(
            GrpcHeaderInterceptor {
                val token = sharedPreferences.getString(HEADER_KEY_AUTHORIZATION, null) ?: ""
                mapOf(HEADER_KEY_AUTHORIZATION to token)
            },
            GrpcLoggingInterceptor { message, level ->
                when (level) {
                    Level.INFO -> Log.i(TAG, message)
                    Level.ERROR -> Log.e(TAG, message)
                }
            }
        )
        return GrpcClientInterceptors(interceptors)
    }
}
