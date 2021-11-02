package com.editor.appcha.ui.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.editor.appcha.ui.R
import com.editor.appcha.ui.base.observe
import com.editor.appcha.ui.component.NetworkImage
import com.editor.appcha.ui.feed.FeedViewModel.Event
import com.editor.appcha.ui.model.AppModel
import com.editor.appcha.ui.model.FeedModel
import com.editor.appcha.ui.theme.AppTheme
import com.editor.appcha.ui.util.playStore
import kotlinx.coroutines.launch

@Composable
fun FeedScreen(
    viewModel: FeedViewModel,
    snackbarHostState: SnackbarHostState,
    navigateToDetail: (feedId: String) -> Unit,
) {
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
) {
    val state = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    LazyColumn(
        state = state,
        verticalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
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
        if (feeds.isNotEmpty()) {
            item {
                FeedScrollToTop {
                    coroutineScope.launch { state.animateScrollToItem(0) }
                }
            }
        }
    }
}

@Composable
private fun FeedItem(
    feed: FeedModel,
    onFeedClick: (FeedModel) -> Unit
) {
    FeedThumbnail(
        feed = feed,
        modifier = Modifier
            .padding(PaddingValues(horizontal = 24.dp))
            .aspectRatio(312f / 400f),
        onClick = onFeedClick
    ) {
        FeedSummary(
            summary = feed.summary,
            modifier = Modifier.fillMaxWidth(),
            paddingValues = PaddingValues(horizontal = 20.dp, vertical = 16.dp)
        )
    }
}

@Composable
private fun FeedItemWithApps(
    feed: FeedModel,
    modifier: Modifier = Modifier,
    onFeedClick: (FeedModel) -> Unit,
    onAppClick: (AppModel) -> Unit
) {
    Column(modifier = modifier) {
        FeedThumbnail(
            feed = feed,
            modifier = Modifier
                .padding(PaddingValues(horizontal = 24.dp))
                .aspectRatio(312f / 192f),
            onClick = onFeedClick
        )
        AppItems(
            apps = feed.apps,
            modifier = Modifier.padding(top = 12.dp),
            onClick = onAppClick
        )
    }
}

@Composable
private fun FeedThumbnail(
    feed: FeedModel,
    modifier: Modifier,
    onClick: (FeedModel) -> Unit,
    content: @Composable ColumnScope.() -> Unit = { }
) {
    FeedCard(
        modifier = modifier,
        onClick = { onClick(feed) }
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                NetworkImage(data = feed.imageUrl)
                FeedTitleAndAuthor(
                    modifier = Modifier.align(Alignment.BottomStart),
                    title = feed.title,
                    author = feed.author
                )
            }
            content()
        }
    }
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
