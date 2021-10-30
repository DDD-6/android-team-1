package com.editor.appcha.ui.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.editor.appcha.ui.R
import com.editor.appcha.ui.base.observe
import com.editor.appcha.ui.component.NetworkImage
import com.editor.appcha.ui.feed.FeedViewModel.Event
import com.editor.appcha.ui.model.AppModel
import com.editor.appcha.ui.model.FeedModel
import com.editor.appcha.ui.theme.AppTheme
import com.editor.appcha.ui.util.playStore
import com.editor.appcha.ui.util.verticalRoundedCornerShape

@Composable
fun FeedScreen(
    snackbarHostState: SnackbarHostState,
    navigateToDetail: (feedId: String) -> Unit,
) {
    val viewModel = hiltViewModel<FeedViewModel>()
    val state: FeedViewModel.State by viewModel.state.collectAsState()
    val feeds = state.feeds
    val context = LocalContext.current

    viewModel.event.observe { event ->
        when (event) {
            is Event.NavigateToDetail -> navigateToDetail(event.id)
            is Event.OpenMarket -> context.playStore(event.url)
        }
    }
    if (state.hasError) {
        val message = stringResource(R.string.feed_error_message)
        LaunchedEffect(state.hasError) {
            snackbarHostState.showSnackbar(message = message)
        }
    }
    if (feeds != null) {
        FeedItems(
            feeds = feeds,
            onFeedClick = viewModel::navigateToDetail,
            onAppClick = viewModel::openMarket
        )
    }
    if (state.loading) {
        Loading()
    }
}

@Composable
private fun FeedItems(
    feeds: List<FeedModel>,
    onFeedClick: (FeedModel) -> Unit,
    onAppClick: (AppModel) -> Unit
) = LazyColumn(
    state = rememberLazyListState(),
    contentPadding = PaddingValues(24.dp),
    verticalArrangement = Arrangement.spacedBy(24.dp)
) {
    items(
        items = feeds,
        key = { it.id }
    ) { feed ->
        if (feed.apps.isEmpty()) {
            FeedItem(
                feed = feed,
                onFeedClick = onFeedClick
            )
        } else {
            FeedItemWithApps(
                feed = feed,
                onFeedClick = onFeedClick,
                onAppClick = onAppClick
            )
        }
    }
}

@Composable
private fun FeedItem(
    feed: FeedModel,
    onFeedClick: (FeedModel) -> Unit
) {
    FeedCard(
        modifier = Modifier.aspectRatio(312f / 400f),
        onClick = { onFeedClick(feed) }
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                NetworkImage(data = feed.imageUrl)
                FeedTitleAndAuthor(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, bottom = 12.dp)
                        .align(Alignment.BottomStart),
                    title = feed.title,
                    author = feed.author
                )
            }
            FeedSummary(
                summary = feed.summary,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(AppTheme.colors.gray2),
                backgroundColor = AppTheme.colors.gray2,
                shape = verticalRoundedCornerShape(bottom = 8.dp)
            )
        }
    }
}

@Composable
private fun FeedItemWithApps(
    feed: FeedModel,
    onFeedClick: (FeedModel) -> Unit,
    onAppClick: (AppModel) -> Unit
) {
    // TODO: Feed Item with Apps UI
}

@Composable
private fun Loading(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(color = AppTheme.colors.primaryLight)
    }
}
