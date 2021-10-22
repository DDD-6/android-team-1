package com.editor.appcha.ui.compose.di

import com.editor.appcha.ui.compose.login.provider.KakaoLoginProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object LoginModule {

    @Provides
    fun providesKakaoLoginProvider() = KakaoLoginProvider()
}