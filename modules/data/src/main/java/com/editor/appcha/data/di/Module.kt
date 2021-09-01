package com.editor.appcha.data.di

import com.editor.appcha.data.repo.GreeterRepositoryImpl
import com.editor.appcha.data.source.GreeterLocalDataSource
import com.editor.appcha.data.source.GreeterRemoteDataSource
import com.editor.appcha.domain.repo.GreeterRepository

fun provideGreeterRepository(
    local: GreeterLocalDataSource,
    remote: GreeterRemoteDataSource
): GreeterRepository = GreeterRepositoryImpl(local, remote)
