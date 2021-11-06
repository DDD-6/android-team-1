package com.editor.appcha.remote.source

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.mapper.toData
import com.editor.appcha.data.model.AppData
import com.editor.appcha.data.model.FeedData
import com.editor.appcha.data.model.FeedDetailData
import com.editor.appcha.data.source.FeedRemoteDataSource
import com.editor.appcha.remote.grpc.Grpc
import com.editor.appcha.remote.model.FeedDetailRemote
import javax.inject.Inject

internal class FeedRemoteDataSourceImpl @Inject constructor(
    grpc: Grpc
) : FeedRemoteDataSource {

    // TODO: 서버 구현
    override suspend fun getFeeds(): Result<List<FeedData>> = Result.success(feeds)

    override suspend fun getFeed(feedId: String): Result<FeedDetailData> = Result.success(
        FeedDetailRemote(
            id = "id",
            title = "title",
            author = "author",
            imageUrl = "https://cdn.pixabay.com/photo/2020/03/31/14/28/paper-4987885_1280.jpg",
            bodies = emptyList(),
            isFavorite = false
        )
    ).toData()

    override suspend fun updateFavorite(feedId: String, isFavorite: Boolean): Result<Unit> =
        Result.success(Unit)
}


private val feeds = listOf(
    FeedData(
        id = "1",
        title = "제목이 들어갑니다.\n내일부터 진짜 운동할건데",
        author = "작성자",
        "요약글이 들어갑니다. 매일 다짐만 하는 프로 다짐러인 당신에게 이 앱을 바칩니다.",
        imageUrl = "https://cdn.pixabay.com/photo/2020/03/31/14/28/paper-4987885_1280.jpg",
        apps = emptyList()
    ),
    FeedData(
        id = "2",
        title = "제목이 들어갑니다.\n내일부터 진짜 운동할건데",
        author = "작성자",
        "요약글이 들어갑니다. 매일 다짐만 하는 프로 다짐러인 당신에게 이 앱을 바칩니다.",
        imageUrl = "https://cdn.pixabay.com/photo/2018/04/22/12/27/butterfly-3340921_1280.png",
        apps = listOf(
            AppData(
                id = "1",
                name = "앱이름",
                description = "마켓에 있는 서브 내용이 들어갑니다. 마켓에 있는 서브 내용이 들어갑니다.",
                imageUrl = null,
                marketUrl = null
            ),
            AppData(
                id = "2",
                name = "앱이름",
                description = "마켓에 있는 서브 내용이 들어갑니다. 마켓에 있는 서브 내용이 들어갑니다.",
                imageUrl = null,
                marketUrl = null
            ),
            AppData(
                id = "3",
                name = "앱이름",
                description = "마켓에 있는 서브 내용이 들어갑니다. 마켓에 있는 서브 내용이 들어갑니다.",
                imageUrl = null,
                marketUrl = null
            )
        )
    ),
    FeedData(
        id = "3",
        title = "제목이 들어갑니다.\n내일부터 진짜 운동할건데",
        author = "작성자",
        "요약글이 들어갑니다. 매일 다짐만 하는 프로 다짐러인 당신에게 이 앱을 바칩니다.",
        imageUrl = "https://cdn.pixabay.com/photo/2015/05/05/01/10/house-753270_1280.jpg",
        apps = emptyList()
    ),
    FeedData(
        id = "4",
        title = "제목이 들어갑니다.\n내일부터 진짜 운동할건데",
        author = "작성자",
        "요약글이 들어갑니다. 매일 다짐만 하는 프로 다짐러인 당신에게 이 앱을 바칩니다.",
        imageUrl = "https://cdn.pixabay.com/photo/2015/05/07/13/43/mussels-756488_1280.jpg",
        apps = emptyList()
    ),
    FeedData(
        id = "5",
        title = "제목이 들어갑니다.\n내일부터 진짜 운동할건데",
        author = "작성자",
        "요약글이 들어갑니다. 매일 다짐만 하는 프로 다짐러인 당신에게 이 앱을 바칩니다.",
        imageUrl = "https://cdn.pixabay.com/photo/2020/06/18/18/03/water-5314502_1280.jpg",
        apps = emptyList()
    )
)
