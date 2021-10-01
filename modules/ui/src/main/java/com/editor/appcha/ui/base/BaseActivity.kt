package com.editor.appcha.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.editor.appcha.core.ui.event.ViewEvent
import com.editor.appcha.core.ui.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseActivity<VM : BaseViewModel<VE, *>, VE : ViewEvent> :
    AppCompatActivity() {

    protected abstract val vm: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                vm.event.collect { event -> handleEvent(event) }
            }
        }
    }

    protected abstract fun handleEvent(event: VE)
}
