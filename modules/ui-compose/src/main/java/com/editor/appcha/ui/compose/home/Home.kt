package com.editor.appcha.ui.compose.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.editor.appcha.ui.compose.community.Community
import com.editor.appcha.ui.compose.community.CommunityWrite
import com.editor.appcha.ui.compose.component.AppText
import com.editor.appcha.ui.compose.feed.Feed
import com.editor.appcha.ui.compose.feed.FeedDetail
import com.editor.appcha.ui.compose.home.HomeScreen.Feed.FEED_ID_KEY
import com.editor.appcha.ui.compose.home.HomeScreen.Profile.PROFILE_ID_KEY
import com.editor.appcha.ui.compose.profile.Profile
import com.editor.appcha.ui.compose.theme.AppTheme

private val TabHeight = 56.dp

@Composable
fun Home() {
    val actions = rememberHomeActions()
    Scaffold(
        topBar = {
            if (actions.showTopBar) {
                HomeTopBar(
                    tabs = actions.tabs,
                    currentTab = actions.currentTab,
                    navigateToTab = { tab -> actions.navigate(tab) }
                )
            }
        }
    ) { paddingValues ->
        HomeGraph(
            modifier = Modifier.padding(paddingValues),
            navController = actions.navController,
            startDestination = HomeScreen.Community.route
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
    navController: NavHostController,
    startDestination: String,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(HomeScreen.Feed.route) {
            Feed()
        }

        composable(
            route = "${HomeScreen.Feed.route}/$FEED_ID_KEY",
            arguments = listOf(navArgument(FEED_ID_KEY) { type = NavType.IntType })
        ) {
            FeedDetail()
        }

        composable(HomeScreen.Community.route) {
            Community()
        }

        composable(route = HomeScreen.CommunityWrite.route) {
            CommunityWrite()
        }

        composable(
            route = "${HomeScreen.Profile.route}/$PROFILE_ID_KEY",
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
