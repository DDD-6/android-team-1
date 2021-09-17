package com.editor.appcha.di

import com.editor.appcha.data.repo.GreeterRepositoryImpl
import com.editor.appcha.domain.repo.GreeterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {

    @Binds
    abstract fun bindGreeterRepository(
        greeterRepositoryImpl: GreeterRepositoryImpl
    ): GreeterRepository
}