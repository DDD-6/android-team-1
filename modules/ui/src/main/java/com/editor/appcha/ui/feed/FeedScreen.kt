package com.editor.appcha.ui.feed

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.editor.appcha.ui.R
import com.editor.appcha.ui.base.observe
import com.editor.appcha.ui.feed.FeedViewModel.Event
import com.editor.appcha.ui.model.AppModel
import com.editor.appcha.ui.model.FeedModel
import com.editor.appcha.ui.theme.AppTheme
import com.editor.appcha.ui.util.playStore

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
        FeedItems(feeds = feeds)
    }
    if (state.loading) {
        Loading()
    }
}

@Composable
private fun FeedItems(feeds: List<FeedModel>) {

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
