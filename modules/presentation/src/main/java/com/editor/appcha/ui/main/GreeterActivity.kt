package com.editor.appcha.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.editor.appcha.data.di.provideGreeterRepository
import com.editor.appcha.domain.repo.GreeterRepository
import com.editor.appcha.domain.usecase.GetNameUseCase
import com.editor.appcha.domain.usecase.SayHelloUseCase
import com.editor.appcha.local.di.provideGreeterLocalDataSource
import com.editor.appcha.remote.di.provideGreeterRemoteDataSource
import com.editor.appcha.ui.theme.AppChaTheme

class GreeterActivity : ComponentActivity() {

    private val repository: GreeterRepository by lazy {
        provideGreeterRepository(
            provideGreeterLocalDataSource(),
            provideGreeterRemoteDataSource()
        )
    }
    private val getNameUseCase by lazy { GetNameUseCase(repo = repository) }
    private val sayHelloUseCase by lazy { SayHelloUseCase(repo = repository) }

    private val factory by lazy {
        GreeterViewModel.Factory(
            getNameUseCase = getNameUseCase,
            sayHelloUseCase = sayHelloUseCase
        )
    }

    private val viewModel by viewModels<GreeterViewModel> { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppChaTheme {
                GreeterScreen(viewModel)
            }
        }
    }
}

@Composable
fun GreeterScreen(viewModel: GreeterViewModel) {
    val focusManager = LocalFocusManager.current
    Column(modifier = Modifier.fillMaxHeight()) {
        NameInput(viewModel) {
            viewModel.sayHello()
            focusManager.clearFocus()
        }
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(viewModel.items.value) { message ->
                Text(
                    text = message,
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

@Composable
fun NameInput(
    viewModel: GreeterViewModel,
    onSend: () -> Unit
) {
    val name = viewModel.input.value

    Row(verticalAlignment = Alignment.CenterVertically) {
        TextField(
            value = name,
            onValueChange = { viewModel.onInputChanged(it) },
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
