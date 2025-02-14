package com.editor.appcha.ui.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.editor.appcha.ui.community.CommunityScreen
import com.editor.appcha.ui.community.CommunityViewModel
import com.editor.appcha.ui.component.AppText
import com.editor.appcha.ui.feed.FeedScreen
import com.editor.appcha.ui.feed.FeedViewModel
import com.editor.appcha.ui.home.HomeRoute.Profile.PROFILE_ID_KEY
import com.editor.appcha.ui.profile.Profile
import com.editor.appcha.ui.theme.AppTheme

private val TabHeight = 56.dp

@Composable
fun Home() {
    val startTab = HomeTab.Feed
    val actions = rememberHomeActions(startTab)
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        topBar = {
            if (actions.showTopBar) {
                HomeTopBar(
                    tabs = actions.tabs,
                    currentTab = actions.currentTab,
                    navigateToTab = { tab -> actions.navigate(tab) }
                )
            }
        },
        scaffoldState = scaffoldState,
    ) { paddingValues ->
        HomeGraph(
            modifier = Modifier.padding(paddingValues),
            actions = actions,
            snackbarHostState = scaffoldState.snackbarHostState
        )
    }
}

@Composable
private fun HomeTopBar(
    tabs: List<HomeTab>,
    currentTab: HomeTab,
    navigateToTab: (HomeTab) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(TabHeight)
    ) {
        HomeTabRow(
            modifier = Modifier.weight(1f),
            tabs = tabs,
            currentTab = currentTab,
            navigateToTab = navigateToTab
        )

        Surface(
            shape = CircleShape,
            color = AppTheme.colors.gray2,
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterVertically)
        ) {
            // TODO: 프로필 사진
        }
        Spacer(modifier = Modifier.width(16.dp))
    }
}

@Composable
private fun HomeTabRow(
    modifier: Modifier,
    tabs: List<HomeTab>,
    currentTab: HomeTab,
    navigateToTab: (HomeTab) -> Unit,
) {
    Row(
        modifier = modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth()
    ) {
        tabs.forEach { tab ->
            val text = stringResource(id = tab.textStringRes)
            val selected = currentTab == tab
            val color = if (selected) AppTheme.colors.gray6 else AppTheme.colors.gray3

            HomeTab(
                text = text,
                color = color,
                padding = 12.dp,
                selected = selected,
                onClick = { navigateToTab(tab) }
            )
        }
    }
}

@Composable
private fun HomeTab(
    text: String,
    color: Color,
    padding: Dp,
    selected: Boolean,
    onClick: () -> Unit
) = AppText(
    text = text,
    color = color,
    style = AppTheme.typography.h2,
    modifier = Modifier
        .selectable(
            selected = selected,
            onClick = { onClick() }
        )
        .padding(padding)
)

@Composable
private fun HomeGraph(
    modifier: Modifier,
    actions: HomeActions,
    snackbarHostState: SnackbarHostState,
) {
    NavHost(
        navController = actions.navController,
        startDestination = actions.startDestination,
        modifier = modifier
    ) {

        composable(HomeRoute.Feed.route) {
            val viewModel: FeedViewModel = hiltViewModel()
            FeedScreen(
                viewModel = viewModel,
                snackbarHostState = snackbarHostState
            )
        }

        composable(HomeRoute.Community.route) {
            val viewModel: CommunityViewModel = hiltViewModel()
            CommunityScreen(viewModel)
        }

        composable(
            route = "${HomeRoute.Profile.route}/$PROFILE_ID_KEY",
            arguments = listOf(
                navArgument(PROFILE_ID_KEY) {
                    type = NavType.StringType
                    defaultValue = "me"
                }
            )
        ) {
            Profile()
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFF
)
@Composable
fun HomeTopBarPreview() {
    AppTheme {
        HomeTopBar(
            tabs = listOf(
                HomeTab.Feed,
                HomeTab.Community
            ),
            currentTab = HomeTab.Feed,
            navigateToTab = { })
    }
}
