package com.editor.appcha.ui.home

import androidx.annotation.StringRes
import com.editor.appcha.ui.R

sealed class HomeTab(
    val route: String,
    @StringRes val textStringRes: Int
) {
    object Feed : HomeTab(
        route = HomeRoute.Feed.route,
        textStringRes = R.string.feed
    )

    object Community : HomeTab(
        route = HomeRoute.Community.route,
        textStringRes = R.string.community
    )
}
