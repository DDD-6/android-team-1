package com.editor.appcha.data.repo

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.mapper.toDomain
import com.editor.appcha.data.source.FeedRemoteDataSource
import com.editor.appcha.domain.model.Feed
import com.editor.appcha.domain.model.FeedDetail
import com.editor.appcha.domain.repo.FeedRepository
import javax.inject.Inject


internal class FeedRepositoryImpl @Inject constructor(
    private val remote: FeedRemoteDataSource
) : FeedRepository {

    override suspend fun getFeeds(): Result<List<Feed>> = remote.getFeeds()
        .map { feeds -> feeds.map { it.toDomain() } }

    override suspend fun getFeed(feedId: String): Result<FeedDetail> =
        remote.getFeed(feedId).toDomain()

    override suspend fun updateFavorite(feedId: String, isFavorite: Boolean): Result<Unit> =
        remote.updateFavorite(feedId, isFavorite)
}
