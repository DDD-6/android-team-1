package com.editor.appcha.data.source

import com.editor.appcha.core.arch.Result
import com.editor.appcha.data.model.FeedData
import com.editor.appcha.data.model.FeedDetailData

interface FeedRemoteDataSource {

    suspend fun getFeeds(): Result<List<FeedData>>

    suspend fun getFeed(feedId: String): Result<FeedDetailData>

    suspend fun updateFavorite(feedId: String, isFavorite: Boolean): Result<Unit>
}
