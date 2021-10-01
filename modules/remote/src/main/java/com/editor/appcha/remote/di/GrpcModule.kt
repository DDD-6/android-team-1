package com.editor.appcha.remote.di

import com.editor.appcha.remote.grpc.Grpc
import com.editor.appcha.remote.grpc.GrpcName
import com.editor.appcha.remote.grpc.GrpcPort
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object GrpcModule {

    @Provides
    @Singleton
    fun provideGrpc(
        name: GrpcName,
        port: GrpcPort
    ): Grpc = Grpc.Builder(name, port).build()
}
