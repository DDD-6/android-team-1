package com.editor.appcha.ui.compose.base

import com.editor.appcha.core.ui.activity.AbstractActivity
import com.editor.appcha.core.ui.event.ViewEvent

abstract class BaseActivity<VM : BaseViewModel<VE, *>, VE : ViewEvent> :
    AbstractActivity<VM, VE>()
