package com.editor.appcha.ui.main

import android.content.Context
import android.content.Intent
import com.editor.appcha.navigation.MainNavigator

internal object MainNavigatorImpl : MainNavigator {

    override fun launch(context: Context) {
        val intent = Intent(context, GreeterActivity::class.java)
        context.startActivity(intent)
    }
}
