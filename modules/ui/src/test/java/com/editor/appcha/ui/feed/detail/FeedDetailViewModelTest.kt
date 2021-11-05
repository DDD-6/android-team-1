package com.editor.appcha.ui.feed.detail

import com.editor.appcha.core.arch.Result
import com.editor.appcha.domain.model.FeedDetail
import com.editor.appcha.domain.usecase.GetFeedUseCase
import com.editor.appcha.ui.BaseTest
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

@ExperimentalCoroutinesApi
class FeedDetailViewModelTest : BaseTest() {

    private val getFeedUseCase: GetFeedUseCase = mockk()

    @Test
    fun `ViewModel을 초기화 하면 FeedDetail을 불러온다`() = runBlockingTest {
        coEvery { getFeedUseCase(any()) } returns Result.success(feedDetail())

        val viewModel = FeedDetailViewModel(getFeedUseCase)

        val actual = viewModel.state.first().feed
        assertThat(actual).isNotNull()
    }

    private fun feedDetail(
        id: String = "id",
        title: String = "title",
        author: String = "author",
        bodies: List<FeedDetail.Body> = emptyList(),
        isFavorite: Boolean = false
    ): FeedDetail = FeedDetail(
        id = id,
        title = title,
        author = author,
        bodies = bodies,
        isFavorite = isFavorite
    )
}
