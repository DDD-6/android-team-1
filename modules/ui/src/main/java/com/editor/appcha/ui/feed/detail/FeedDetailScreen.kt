package com.editor.appcha.ui.feed.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.editor.appcha.ui.R
import com.editor.appcha.ui.component.NetworkImage
import com.editor.appcha.ui.feed.FeedTitleAndAuthor
import com.editor.appcha.ui.theme.AppTheme
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun FeedDetailScreen(viewModel: FeedDetailViewModel = viewModel()) {
    val state by viewModel.state.collectAsState()
    val feed = state.feed

    Box(modifier = Modifier.verticalScroll(rememberScrollState())) {
        if (feed == null) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            Column {
                FeedDetailThumbnail(
                    imageUrl = feed.imageUrl,
                    title = feed.title,
                    author = feed.author,
                    modifier = Modifier.aspectRatio(360f / 472f)
                )
            }
            TopSection(
                isFavorite = feed.isFavorite,
                onClose = viewModel::navigateUp,
                onFavorite = viewModel::toggleFavorite
            )
        }
    }
}

@Composable
private fun TopSection(
    isFavorite: Boolean,
    onClose: () -> Unit,
    onFavorite: () -> Unit
) {
    Box(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_close),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp)
                .size(32.dp)
                .clip(CircleShape)
                .clickable { onClose() }
        )

        Icon(
            painter = painterResource(R.drawable.ic_heart),
            contentDescription = null,
            tint = if (isFavorite) {
                AppTheme.colors.primary
            } else {
                Color.White
            },
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 16.dp)
                .size(32.dp)
                .clip(CircleShape)
                .clickable { onFavorite() }
                .padding(4.dp)
        )
    }
}

@Composable
private fun FeedDetailThumbnail(
    imageUrl: String,
    title: String,
    author: String,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        NetworkImage(data = imageUrl)
        FeedTitleAndAuthor(
            title = title, author = author,
            modifier = Modifier.align(Alignment.BottomStart)
        )
    }
}
