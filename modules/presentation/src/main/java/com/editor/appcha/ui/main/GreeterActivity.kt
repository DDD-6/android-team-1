package com.editor.appcha.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.editor.appcha.core.ui.activity.AbstractActivity
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
                GreeterActivityScreen(vm)
            }
        }
    }

    override fun handleEvent(event: GreeterViewModel.Event) {
        // no-op
    }
}
