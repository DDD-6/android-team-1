package com.editor.appcha.ui.compose.home

sealed class HomeScreen(val route: String) {

    object Feed : HomeScreen("feed") {
        const val FEED_ID_KEY = "feedId"
    }

    object Community : HomeScreen("community")

    object CommunityWrite : HomeScreen("community/write")

    object Profile : HomeScreen("profile") {
        const val PROFILE_ID_KEY = "profileId"
    }
}
