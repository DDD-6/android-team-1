package com.editor.appcha.remote.source

import com.editor.appcha.core.arch.Result
import com.editor.appcha.data.model.FeedData
import com.editor.appcha.data.source.FeedRemoteDataSource
import com.editor.appcha.remote.grpc.Grpc
import javax.inject.Inject

internal class FeedRemoteDataSourceImpl @Inject constructor(
    grpc: Grpc
) : FeedRemoteDataSource {

    override suspend fun getFeeds(): Result<List<FeedData>> = Result.success(emptyList())
}
