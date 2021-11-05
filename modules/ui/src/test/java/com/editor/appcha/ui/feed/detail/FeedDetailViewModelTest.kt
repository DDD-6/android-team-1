package com.editor.appcha.ui.feed.detail

import androidx.lifecycle.SavedStateHandle
import com.editor.appcha.core.arch.Result
import com.editor.appcha.domain.model.FeedDetail
import com.editor.appcha.domain.usecase.GetFeedUseCase
import com.editor.appcha.ui.BaseTest
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.coVerify
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
        // given
        coEvery { getFeedUseCase(any()) } returns Result.success(feedDetail())
        val savedStateHandle = SavedStateHandle(mapOf(FeedDetailViewModel.KEY_FEED_ID to "1"))

        // when
        val viewModel = FeedDetailViewModel(getFeedUseCase, savedStateHandle)
        val actual = viewModel.state.first().feed

        // then
        assertThat(actual).isNotNull()
    }

    @Test
    fun `Bundle로 받은 feedId가 없으면 getFeedUseCase를 호출하지 않는다`() = runBlockingTest {
        // given
        val id = ""
        coEvery { getFeedUseCase(id) } returns Result.success(feedDetail(id = id))
        val savedStateHandle = SavedStateHandle(mapOf(FeedDetailViewModel.KEY_FEED_ID to id))

        // when
        FeedDetailViewModel(getFeedUseCase, savedStateHandle)

        // then
        coVerify(exactly = 0) { getFeedUseCase(id) }
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
