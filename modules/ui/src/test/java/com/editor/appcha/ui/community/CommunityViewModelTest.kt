package com.editor.appcha.ui.community

import com.editor.appcha.ui.BaseTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

@ExperimentalCoroutinesApi
class CommunityViewModelTest : BaseTest() {

    @Test
    fun `ViewModel을 초기화 하면 0개 이상의 Board 목록을 불러온다`() = runBlockingTest {

        // when
        val viewModel = CommunityViewModel()

        // then
        val actual = viewModel.state.first().boards
        assertThat(actual).isNotNull()
    }
}
