package com.editor.appcha.data.repo

import com.editor.appcha.core.arch.Result
import com.editor.appcha.data.source.FeedRemoteDataSource
import com.editor.appcha.domain.model.Feed
import com.editor.appcha.domain.repo.FeedRepository
import javax.inject.Inject


internal class FeedRepositoryImpl @Inject constructor(
    private val remote: FeedRemoteDataSource
) : FeedRepository {

    override suspend fun getFeeds(): Result<List<Feed>> = remote.getFeeds()
        .map { feeds -> feeds.map { it.toDomain() } }
}
