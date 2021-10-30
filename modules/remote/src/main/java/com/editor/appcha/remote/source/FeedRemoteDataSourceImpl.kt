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
                title = "제목이 들어갑니다.\n내일부터 진짜 운동할건데",
                author = "작성자",
                "요약글이 들어갑니다. 매일 다짐만 하는 프로 다짐러인 당신에게 이 앱을 바칩니다.",
                imageUrl = "https://cdn.pixabay.com/photo/2020/03/31/14/28/paper-4987885_1280.jpg",
                apps = emptyList()
            )
        }
    )
}
