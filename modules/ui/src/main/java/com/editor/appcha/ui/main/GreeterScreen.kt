package com.editor.appcha.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.editor.appcha.core.ui.state.LoadState
import com.editor.appcha.ui.core.arch.sample.GreeterModel

@Composable
fun GreeterActivityScreen(viewModel: GreeterViewModel) {
    val focusManager = LocalFocusManager.current

    val state by viewModel.state.collectAsState()
    val loadState by viewModel.loadState.collectAsState()

    GreeterScreen(
        loading = loadState == LoadState.LOADING,
        input = state.input,
        items = state.items,
        onTextChange = { viewModel.onInputChanged(it) },
        onSend = {
            focusManager.clearFocus()
            viewModel.sayHello()
        }
    )
}

@Composable
fun GreeterScreen(
    loading: Boolean,
    input: String,
    items: List<GreeterModel>,
    onTextChange: (String) -> Unit,
    onSend: () -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (loading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        Column(modifier = Modifier.fillMaxHeight()) {
            NameInput(
                text = input,
                onTextChange = onTextChange,
                onSend = onSend,
            )
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(items) { greeter ->
                    Text(
                        text = greeter.message,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                            .align(Alignment.Start),
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }
}

@Composable
fun NameInput(
    text: String,
    onTextChange: (String) -> Unit,
    onSend: () -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        TextField(
            value = text,
            onValueChange = { onTextChange(it) },
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Send),
            keyboardActions = KeyboardActions(
                onSend = { onSend() }
            ),
            modifier = Modifier
                .weight(1f)
                .padding(4.dp),
        )
        Icon(
            imageVector = Icons.Sharp.Send,
            contentDescription = "",
            modifier = Modifier
                .size(48.dp)
                .clickable { onSend() }
                .padding(12.dp)
        )
    }
}
