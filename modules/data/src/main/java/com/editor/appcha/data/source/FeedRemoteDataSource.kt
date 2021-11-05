package com.editor.appcha.data.source

import com.editor.appcha.core.arch.Result
import com.editor.appcha.data.model.FeedData

interface FeedRemoteDataSource {

    suspend fun getFeeds(): Result<List<FeedData>>

    suspend fun getFeed(feedId: String): Result<FeedData>
}
