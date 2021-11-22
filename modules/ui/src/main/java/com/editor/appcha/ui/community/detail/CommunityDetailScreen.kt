package com.editor.appcha.ui.community.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.editor.appcha.ui.R
import com.editor.appcha.ui.community.CommunityAuthorAndCreatedAt
import com.editor.appcha.ui.community.CommunityCommentIcon
import com.editor.appcha.ui.component.AppText
import com.editor.appcha.ui.model.BoardModel
import com.editor.appcha.ui.model.CommentModel
import com.editor.appcha.ui.theme.AppTheme
import kotlinx.coroutines.launch

@Composable
fun CommunityDetailScreen(viewModel: CommunityDetailViewModel) {
    val state by viewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar { viewModel.navigateUp() }

        val scrollState = rememberLazyListState()
        val coroutineScope = rememberCoroutineScope()
        if (!state.loading) {
            CommunityDetailItems(
                board = state.board!!,
                comments = state.comments ?: emptyList(),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                scrollState = scrollState
            )

            UserInputText(
                text = state.input,
                onTextChange = { viewModel.onInputChange(it) },
                onPost = { viewModel.postComment() }
            )
        }
        SideEffect {
            val index = state.comments?.size ?: 0
            coroutineScope.launch { scrollState.animateScrollToItem(index) }
        }
    }
}

@Composable
private fun TopAppBar(navigateUp: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
    ) {
        Spacer(modifier = Modifier.width(12.dp))
        Icon(
            painter = painterResource(R.drawable.ic_arrow),
            contentDescription = null,
            tint = AppTheme.colors.gray6,
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .clickable { navigateUp() }
                .padding(4.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        AppText(
            text = stringResource(id = R.string.community),
            style = AppTheme.typography.body1,
            color = AppTheme.colors.gray6
        )
    }
}

@Composable
private fun CommunityDetailItems(
    board: BoardModel,
    comments: List<CommentModel>,
    modifier: Modifier,
    scrollState: LazyListState,
) {
    LazyColumn(modifier = modifier, state = scrollState) {
        item(board.id) { BoardItem(board) }
        items(items = comments) { comment -> CommentItem(comment = comment) }
    }
}

@Composable
private fun BoardItem(board: BoardModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        val horizontalPadding = Modifier.padding(horizontal = 24.dp)

        Divider(color = AppTheme.colors.gray2, modifier = Modifier.height(1.dp))

        Spacer(modifier = Modifier.height(16.dp))
        AppText(
            text = board.title,
            style = AppTheme.typography.body1,
            color = AppTheme.colors.gray6,
            modifier = horizontalPadding
        )

        Spacer(modifier = Modifier.height(8.dp))
        CommunityAuthorAndCreatedAt(
            author = board.author,
            createdAt = board.createdAt,
            modifier = horizontalPadding
        )

        Spacer(modifier = Modifier.height(16.dp))
        Divider(
            color = AppTheme.colors.gray1,
            modifier = Modifier
                .height(1.dp)
                .then(horizontalPadding)
        )
        Spacer(modifier = Modifier.height(16.dp))

        AppText(
            text = board.body,
            style = AppTheme.typography.body1,
            color = AppTheme.colors.gray6,
            modifier = horizontalPadding
        )

        Spacer(modifier = Modifier.height(24.dp))
        CommunityCommentIcon(count = board.commentCount, modifier = horizontalPadding.height(44.dp))
        Divider(color = AppTheme.colors.gray2, modifier = Modifier.height(1.dp))
    }
}

@Composable
private fun CommentItem(comment: CommentModel) {
    Column {
        Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)) {
            AppText(
                text = comment.author,
                style = AppTheme.typography.caption,
                color = AppTheme.colors.gray5
            )
            Spacer(modifier = Modifier.height(4.dp))
            AppText(
                text = "댓글 작성시간",
                style = AppTheme.typography.caption,
                color = AppTheme.colors.gray4
            )
            Spacer(modifier = Modifier.height(4.dp))
            AppText(
                text = comment.text,
                style = AppTheme.typography.caption,
                color = AppTheme.colors.gray6
            )
        }
        Divider(color = AppTheme.colors.gray1, modifier = Modifier.height(1.dp))
    }
}


@Composable
private fun UserInputText(
    text: String,
    onTextChange: (String) -> Unit,
    onPost: () -> Unit,
) {
    Column(modifier = Modifier.height(52.dp)) {
        Divider(color = AppTheme.colors.gray1)
        Row {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(start = 24.dp, end = 20.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                BasicTextField(
                    value = text,
                    onValueChange = onTextChange,
                    modifier = Modifier.fillMaxWidth(),
                    cursorBrush = SolidColor(AppTheme.colors.gray6),
                    textStyle = AppTheme.typography.body1.copy(color = AppTheme.colors.gray6),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
                    keyboardActions = KeyboardActions(onSend = { onPost() })
                )
                if (text.isEmpty()) {
                    AppText(
                        text = "댓글을 작성해주세요.",
                        style = AppTheme.typography.body2,
                        color = AppTheme.colors.gray3,
                    )
                }
            }
            if (text.isNotEmpty()) {
                AppText(
                    text = "등록",
                    style = AppTheme.typography.body2,
                    color = AppTheme.colors.primary,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .clickable { onPost() }
                        .padding(4.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}
