package com.editor.appcha.local.di

import com.editor.appcha.data.source.TokenLocalDataSource
import com.editor.appcha.local.TokenLocalDataSourceImpl
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
    abstract fun bindsTokenDataSource(
        tokenLocalDataSourceImpl: TokenLocalDataSourceImpl
    ): TokenLocalDataSource
}
