package com.editor.appcha.di

import com.editor.appcha.remote.grpc.GrpcName
import com.editor.appcha.remote.grpc.GrpcPort
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object AppModule {

    @Provides
    fun provideGrpcName(): GrpcName = GrpcName("localhost")

    @Provides
    fun provideGrpcPort(): GrpcPort = GrpcPort(8888)
}
