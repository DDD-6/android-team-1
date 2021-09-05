package com.editor.appcha.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import com.editor.appcha.core.ui.activity.AbstractActivity
import com.editor.appcha.core.ui.state.LoadState
import com.editor.appcha.data.di.provideGreeterRepository
import com.editor.appcha.domain.repo.GreeterRepository
import com.editor.appcha.domain.usecase.GetNameUseCase
import com.editor.appcha.domain.usecase.SayHelloUseCase
import com.editor.appcha.local.di.provideGreeterLocalDataSource
import com.editor.appcha.remote.di.provideGreeterRemoteDataSource
import com.editor.appcha.ui.theme.AppChaTheme

class GreeterActivity : AbstractActivity<GreeterViewModel, GreeterViewModel.Event>() {

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

    override val vm by viewModels<GreeterViewModel> { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppChaTheme {
                GreeterScreen(vm)
            }
        }
    }

    override fun handleEvent(event: GreeterViewModel.Event) {
        // no-op
    }
}

@Composable
fun GreeterScreen(viewModel: GreeterViewModel) {
    val focusManager = LocalFocusManager.current
    val loadState: LoadState by viewModel.loadState.collectAsState()
    val state: GreeterViewModel.State by viewModel.state.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        if (loadState == LoadState.LOADING) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        Column(modifier = Modifier.fillMaxHeight()) {
            NameInput(viewModel) {
                viewModel.sayHello()
                focusManager.clearFocus()
            }
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.items) { greeter ->
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
    viewModel: GreeterViewModel,
    onSend: () -> Unit
) {
    val state: GreeterViewModel.State by viewModel.state.collectAsState()

    Row(verticalAlignment = Alignment.CenterVertically) {
        TextField(
            value = state.input,
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
