package com.editor.appcha.remote.source

import com.editor.appcha.core.arch.Result
import com.editor.appcha.data.model.FeedData
import com.editor.appcha.data.source.FeedRemoteDataSource
import com.editor.appcha.remote.grpc.Grpc
import javax.inject.Inject

internal class FeedRemoteDataSourceImpl @Inject constructor(
    grpc: Grpc
) : FeedRemoteDataSource {

    // TODO: 서버 구현
    override suspend fun getFeeds(): Result<List<FeedData>> = Result.success(
        List(5) {
            FeedData(
                id = "$it",
                title = "$it Feed title",
                author = "$it Feed author",
                "Lorem ipsum dolor sit amet.",
                imageUrl = "http://image.kyobobook.co.kr/newimages/giftshop_new/goods/400/1148/S1626762386377.jpg",
                apps = emptyList()
            )
        }
    )
}
