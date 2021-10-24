package com.editor.appcha.data.di

import com.editor.appcha.data.repo.FeedRepositoryImpl
import com.editor.appcha.data.repo.LoginRepositoryImpl
import com.editor.appcha.domain.repo.FeedRepository
import com.editor.appcha.domain.repo.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindsLoginRepository(repo: LoginRepositoryImpl): LoginRepository

    @Singleton
    @Binds
    abstract fun bindsFeedRepository(repo: FeedRepositoryImpl): FeedRepository
}
