package com.editor.appcha.domain.repo

import com.editor.appcha.core.arch.Result
import com.editor.appcha.domain.model.Feed
import com.editor.appcha.domain.model.FeedDetail

interface FeedRepository {

    suspend fun getFeeds(): Result<List<Feed>>

    suspend fun getFeed(feedId: String): Result<FeedDetail>

    suspend fun updateFavorite(feedId: String, isFavorite: Boolean): Result<Unit>
}
