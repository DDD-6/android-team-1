package com.editor.appcha.local.di

import com.editor.appcha.data.source.GreeterLocalDataSource
import com.editor.appcha.local.source.GreeterLocalDataSourceImpl

fun provideGreeterLocalDataSource(): GreeterLocalDataSource = GreeterLocalDataSourceImpl()
