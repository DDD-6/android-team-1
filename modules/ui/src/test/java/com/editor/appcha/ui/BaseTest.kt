package com.editor.appcha.ui

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule

@ExperimentalCoroutinesApi
abstract class BaseTest {

    @get:Rule
    var coroutinesRule = CoroutinesRule()
}
