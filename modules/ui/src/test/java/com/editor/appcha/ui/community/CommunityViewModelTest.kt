package com.editor.appcha.ui.community

import com.editor.appcha.core.arch.Result
import com.editor.appcha.domain.model.Board
import com.editor.appcha.domain.usecase.GetBoardListUseCase
import com.editor.appcha.ui.BaseTest
import com.editor.appcha.ui.community.CommunityViewModel.Event
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import java.time.LocalDateTime

@ExperimentalCoroutinesApi
class CommunityViewModelTest : BaseTest() {

    private val getBoardListUseCase: GetBoardListUseCase = mockk()

    @Test
    fun `ViewModel을 초기화 하면 0개 이상의 Board목록을 불러온다`() = runBlockingTest {
        // given
        coEvery { getBoardListUseCase(Unit) } returns Result.success(listOf())

        // when
        val viewModel = CommunityViewModel(getBoardListUseCase)

        // then
        val actual = viewModel.state.first().boards
        assertThat(actual).isNotNull()
    }

    @Test
    fun `Board를 클릭하면 NavigateToDetail Event가 발생한다`() = runBlockingTest {
        // given
        val board = board()
        coEvery { getBoardListUseCase(Unit) } returns Result.success(listOf(board))
        val viewModel = CommunityViewModel(getBoardListUseCase)

        // when
        val state = viewModel.state.first()
        viewModel.navigateToDetail(state.boards!!.first())

        // then
        val actual = viewModel.event.first()
        assertThat(actual).isEqualTo(Event.NavigateToDetail(boardId = board.id))
    }

    @Test
    fun `Post버튼을 클릭하면 NavigateToPost Event가 발생한다`() = runBlockingTest {
        // given
        coEvery { getBoardListUseCase(Unit) } returns Result.success(listOf())
        val viewModel = CommunityViewModel(getBoardListUseCase)

        // when
        viewModel.navigateToPost()

        // then
        val actual = viewModel.event.first()
        assertThat(actual).isInstanceOf(Event.NavigateToPost::class.java)
    }

    private fun board(
        id: String = "id",
        title: String = "title",
        author: String = "author",
        commentCount: Int = 0,
        body: String = "",
        createdAt: LocalDateTime = LocalDateTime.now()
    ) = Board(
        id = id,
        title = title,
        author = author,
        commentCount = commentCount,
        body = body,
        createdAt = createdAt,
    )
}
