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
                // TODO: Preferences에서 Header 가져오기
                mapOf()
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
