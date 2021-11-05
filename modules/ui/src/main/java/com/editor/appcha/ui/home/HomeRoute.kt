package com.editor.appcha.ui.home

sealed class HomeRoute(val route: String) {

    object Feed : HomeRoute("feed")

    object Community : HomeRoute("community")

    object CommunityWrite : HomeRoute("community/write")

    object Profile : HomeRoute("profile") {
        const val PROFILE_ID_KEY = "profileId"
    }
}
