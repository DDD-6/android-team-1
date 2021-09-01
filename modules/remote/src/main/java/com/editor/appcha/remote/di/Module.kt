package com.editor.appcha.remote.di

import com.editor.appcha.data.source.GreeterRemoteDataSource
import com.editor.appcha.remote.source.GreeterRemoteDataSourceImpl

fun provideGreeterRemoteDataSource(): GreeterRemoteDataSource = GreeterRemoteDataSourceImpl()
