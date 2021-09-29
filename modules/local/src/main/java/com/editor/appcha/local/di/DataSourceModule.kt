package com.editor.appcha.local.di

import com.editor.appcha.data.source.GreeterLocalDataSource
import com.editor.appcha.local.source.GreeterLocalDataSourceImpl
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
    abstract fun bindGreeterLocalDataSource(
        greeterLocalDataSourceImpl: GreeterLocalDataSourceImpl
    ): GreeterLocalDataSource
}
