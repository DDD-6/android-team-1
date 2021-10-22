package com.editor.appcha.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.editor.appcha.core.ui.event.ViewEvent
import com.editor.appcha.core.ui.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseFragment<VM : BaseViewModel<VE, *>, VE : ViewEvent>() : Fragment() {

    protected abstract val vm: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                vm.event.collect { event -> handleEvent(event) }
            }
        }
    }

    protected abstract fun handleEvent(event: VE)
}
