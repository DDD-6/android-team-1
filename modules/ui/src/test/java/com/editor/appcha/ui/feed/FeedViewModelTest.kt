package com.editor.appcha.ui.feed

import com.editor.appcha.core.arch.Result
import com.editor.appcha.domain.model.App
import com.editor.appcha.domain.model.Feed
import com.editor.appcha.domain.usecase.GetFeedList
import com.editor.appcha.ui.CoroutinesRule
import com.editor.appcha.ui.feed.FeedViewModel.Event
import com.editor.appcha.ui.model.FeedModel
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class FeedViewModelTest {

    @get:Rule
    var coroutinesRule = CoroutinesRule()

    private val getFeedList: GetFeedList = mockk()

    @Test
    fun `ViewModel을 초기화 하면 0개 이상의 Feed 목록을 불러온다`() = runBlockingTest {
        // given
        coEvery { getFeedList(Unit) } returns Result.success(listOf())

        // when
        val viewModel = FeedViewModel(getFeedList)

        // then
        val expected = FeedViewModel.State(emptyList(), false, null)
        val actual = viewModel.state.first()
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `Feed를 클릭하면 NavigateToDetail Event가 발생한다`() = runBlockingTest {
        // given
        val feed = feed()
        coEvery { getFeedList(Unit) } returns Result.success(listOf(feed))
        val viewModel = FeedViewModel(mockk())

        // when
        viewModel.navigateToDetail(FeedModel(feed))

        // then
        val expected = Event.NavigateToDetail(id = feed.id)
        val actual = viewModel.event.first()
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `App을 클릭하면 OpenMarket Event가 발생한다`() = runBlockingTest {
        // given
        val marketUrl = "kr.perfectree.heydealer"
        val feed = feed(apps = listOf(app(marketUrl = marketUrl)))
        coEvery { getFeedList(Unit) } returns Result.success(listOf(feed))
        val viewModel = FeedViewModel(getFeedList)

        // when
        val state = viewModel.state.first()
        val app = state.feeds!!.first().apps.first()
        viewModel.openMarket(app)

        // then
        val expected = Event.OpenMarket(url = marketUrl)
        val actual = viewModel.event.first()
        assertThat(actual).isEqualTo(expected)
    }

    private fun feed(
        id: String = "",
        title: String = "",
        author: String = "",
        summary: String = "",
        apps: List<App> = emptyList()
    ): Feed = Feed(
        id = id,
        title = title,
        author = author,
        summary = summary,
        apps = apps
    )

    private fun app(
        id: String = "",
        name: String = "",
        description: String = "",
        imageUrl: String = "",
        marketUrl: String = ""
    ): App = App(
        id = id,
        name = name,
        description = description,
        imageUrl = imageUrl,
        marketUrl = marketUrl
    )
}
