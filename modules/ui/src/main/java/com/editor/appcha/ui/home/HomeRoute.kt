package com.editor.appcha.ui.home

sealed class HomeRoute(val route: String) {

    object Feed : HomeRoute("feed") {
        const val FEED_ID_KEY = "feedId"
    }

    object Community : HomeRoute("community")

    object CommunityWrite : HomeRoute("community/write")

    object Profile : HomeRoute("profile") {
        const val PROFILE_ID_KEY = "profileId"
    }
}
