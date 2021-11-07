package com.editor.appcha.ui.feed.detail

import androidx.lifecycle.SavedStateHandle
import com.editor.appcha.core.arch.Result
import com.editor.appcha.domain.model.FeedDetail
import com.editor.appcha.domain.usecase.GetFeedUseCase
import com.editor.appcha.domain.usecase.UpdateFavoriteUseCase
import com.editor.appcha.ui.BaseTest
import com.editor.appcha.ui.feed.detail.FeedDetailViewModel.Event
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
    private val updateFavoriteUseCase: UpdateFavoriteUseCase = mockk()

    @Test
    fun `ViewModel을 초기화 하면 FeedDetail을 불러온다`() = runBlockingTest {
        // given
        coEvery { getFeedUseCase(any()) } returns Result.success(feedDetail())
        val savedStateHandle = SavedStateHandle(mapOf(FeedDetailViewModel.KEY_FEED_ID to "1"))

        // when
        val viewModel = FeedDetailViewModel(getFeedUseCase, mockk(), savedStateHandle)
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
        FeedDetailViewModel(getFeedUseCase, mockk(), savedStateHandle)

        // then
        coVerify(exactly = 0) { getFeedUseCase(id) }
    }

    @Test
    fun `찜하기 상태에서 찜하기 버튼을 클릭하면 해제 상태가 된다`() = runBlockingTest {
        // given
        coEvery { getFeedUseCase(any()) } returns Result.success(feedDetail(isFavorite = true))
        val savedStateHandle = SavedStateHandle(mapOf(FeedDetailViewModel.KEY_FEED_ID to "1"))
        val viewModel = FeedDetailViewModel(getFeedUseCase, mockk(), savedStateHandle)

        // when
        viewModel.toggleFavorite()
        val actual = viewModel.state.first().feed?.isFavorite

        // then
        assertThat(actual).isFalse()
    }

    @Test
    fun `찜하기 버튼을 클릭하면 UpdateFavoriteUseCase를 호출한다`() = runBlockingTest {
        // given
        coEvery { getFeedUseCase(any()) } returns Result.success(feedDetail())
        coEvery { updateFavoriteUseCase(any()) } returns Result.success(Unit)
        val savedStateHandle = SavedStateHandle(mapOf(FeedDetailViewModel.KEY_FEED_ID to "1"))
        val viewModel = FeedDetailViewModel(getFeedUseCase, updateFavoriteUseCase, savedStateHandle)

        // when
        viewModel.toggleFavorite()

        // then
        coVerify { updateFavoriteUseCase(any()) }
    }

    @Test
    fun `뒤로가기 버튼을 클릭하면 NavigateUp Event가 발생한다`() = runBlockingTest {
        // given
        val savedStateHandle = SavedStateHandle(mapOf(FeedDetailViewModel.KEY_FEED_ID to "1"))
        val viewModel = FeedDetailViewModel(mockk(), mockk(), savedStateHandle)

        // when
        viewModel.navigateUp()

        // then
        val actual = viewModel.event.first()
        assertThat(actual).isInstanceOf(Event.NavigateUp::class.java)
    }

    private fun feedDetail(
        id: String = "id",
        title: String = "title",
        author: String = "author",
        imageUrl: String = "",
        summary: String = "summary",
        bodies: List<FeedDetail.Body> = emptyList(),
        isFavorite: Boolean = false
    ): FeedDetail = FeedDetail(
        id = id,
        title = title,
        author = author,
        imageUrl = imageUrl,
        summary = summary,
        bodies = bodies,
        isFavorite = isFavorite
    )
}
