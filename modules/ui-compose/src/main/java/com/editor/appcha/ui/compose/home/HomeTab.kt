package com.editor.appcha.ui.compose.home

import androidx.annotation.StringRes
import com.editor.appcha.ui.compose.R

sealed class HomeTab(
    val route: String,
    @StringRes val textStringRes: Int
) {
    object Feed : HomeTab(
        route = HomeScreen.Feed.route,
        textStringRes = R.string.feed
    )

    object Community : HomeTab(
        route = HomeScreen.Community.route,
        textStringRes = R.string.community
    )
}
