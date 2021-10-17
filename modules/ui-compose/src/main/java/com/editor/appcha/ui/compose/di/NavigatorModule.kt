package com.editor.appcha.ui.compose.di

import android.content.Context
import android.content.Intent
import com.editor.appcha.navigation.MainNavigator
import com.editor.appcha.ui.compose.main.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object NavigatorModule {

    @Provides
    fun provideMainNavigator(): MainNavigator = object : MainNavigator {

        override fun launch(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
}
