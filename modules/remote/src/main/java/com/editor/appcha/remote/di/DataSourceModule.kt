package com.editor.appcha.remote.di

import com.editor.appcha.data.source.FeedRemoteDataSource
import com.editor.appcha.data.source.LoginRemoteDataSource
import com.editor.appcha.remote.source.FeedRemoteDataSourceImpl
import com.editor.appcha.remote.source.LoginRemoteDataSourcesImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindsFeedDataSource(
        source: FeedRemoteDataSourceImpl
    ): FeedRemoteDataSource

    @Singleton
    @Binds
    abstract fun bindsLoginDataSource(
        source: LoginRemoteDataSourcesImpl
    ): LoginRemoteDataSource
}
