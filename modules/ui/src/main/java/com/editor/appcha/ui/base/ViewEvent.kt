package com.editor.appcha.ui.base

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

interface ViewEvent

object EmptyViewEvent : ViewEvent

@SuppressLint("ComposableNaming")
@Composable
fun <T : ViewEvent> Flow<T>.observe(block: (T) -> Unit) {
    LaunchedEffect(Unit) {
        collect { event -> block(event) }
    }
}
