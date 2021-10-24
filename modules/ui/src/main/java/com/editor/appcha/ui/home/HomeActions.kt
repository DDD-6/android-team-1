package com.editor.appcha.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberHomeActions(
    startTab: HomeTab,
    navController: NavHostController = rememberNavController()
) = remember(navController) {
    HomeActions(
        startTab = startTab,
        navController = navController
    )
}

@Stable
class HomeActions(
    startTab: HomeTab,
    val navController: NavHostController
) {

    val tabs: List<HomeTab> = listOf(
        HomeTab.Feed,
        HomeTab.Community
    )

    private val tabRoutes = tabs.map { it.route }

    var currentTab by mutableStateOf<HomeTab>(startTab)
        private set

    val showTopBar: Boolean
        @Composable
        get() {
            val backstackEntry by navController.currentBackStackEntryAsState()
            return backstackEntry?.destination?.route in tabRoutes
        }

    fun navigate(tab: HomeTab) {
        if (currentTab == tab) {
            return
        }
        currentTab = tab
        navController.navigate(tab.route) {
            popUpTo(navController.graph.id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateToProfile(profileId: String) {
        navController.navigate("${HomeScreen.Profile.route}/$profileId")
    }
}
