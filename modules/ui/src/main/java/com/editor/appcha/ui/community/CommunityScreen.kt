package com.editor.appcha.ui.community

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.editor.appcha.ui.component.AppText
import com.editor.appcha.ui.model.BoardModel
import com.editor.appcha.ui.theme.AppTheme

@Composable
fun CommunityScreen(viewModel: CommunityViewModel) {
    val state by viewModel.state.collectAsState()
    val boards = state.boards

    Box(modifier = Modifier.fillMaxSize()) {
        if (boards.isNullOrEmpty()) {
            CircularProgressIndicator(
                color = AppTheme.colors.primary,
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            BoardItems(
                boards = boards,
                onClick = viewModel::navigateToDetail
            )
        }
    }
}

@Composable
private fun BoardItems(
    boards: List<BoardModel>,
    onClick: (BoardModel) -> Unit,
) {
    LazyColumn {
        items(
            items = boards,
            key = { it.id }
        ) { board ->
            Divider(color = AppTheme.colors.gray2)
            BoardItem(board = board, onClick = onClick)
        }
    }
}

@Composable
private fun BoardItem(board: BoardModel, onClick: (BoardModel) -> Unit) {
    Column(modifier = Modifier
        .clickable { onClick(board) }
        .padding(top = 16.dp, bottom = 12.dp, start = 24.dp, end = 24.dp)) {
        AppText(
            text = board.title,
            style = AppTheme.typography.body2,
            color = AppTheme.colors.gray6
        )
        Spacer(modifier = Modifier.height(16.dp))
        CommunityAuthorAndCreatedAt(author = board.author, createdAt = board.createdAt)
        Spacer(modifier = Modifier.height(8.dp))
        CommunityCommentIcon(count = board.commentCount)
    }
}
