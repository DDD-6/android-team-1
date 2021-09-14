package com.editor.appcha.ui.splash

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Button
import androidx.compose.material.Text
import com.editor.appcha.ui.main.MainNavigatorImpl

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navigator = MainNavigatorImpl

        setContent {
            Button(
                onClick = { navigator.launch(this) }
            ) {
                Text("Main")
            }
        }
    }
}
