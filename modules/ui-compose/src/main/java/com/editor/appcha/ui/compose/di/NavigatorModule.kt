package com.editor.appcha.ui.compose.di

import android.content.Context
import android.content.Intent
import com.editor.appcha.navigation.HomeNavigator
import com.editor.appcha.ui.compose.home.HomeActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object NavigatorModule {

    @Provides
    fun provideHomeNavigator(): HomeNavigator = object : HomeNavigator {

        override fun launch(context: Context) {
            val intent = Intent(context, HomeActivity::class.java)
            context.startActivity(intent)
        }
    }
}
