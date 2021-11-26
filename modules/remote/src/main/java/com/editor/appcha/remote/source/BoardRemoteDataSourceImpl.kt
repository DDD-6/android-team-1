package com.editor.appcha.remote.source

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.buildResult
import com.editor.appcha.core.arch.mapper.toData
import com.editor.appcha.data.model.BoardData
import com.editor.appcha.data.model.CommentData
import com.editor.appcha.data.model.request.PostBoardData
import com.editor.appcha.data.model.request.PostCommentData
import com.editor.appcha.data.source.BoardRemoteDataSource
import com.editor.appcha.remote.grpc.Grpc
import com.editor.appcha.remote.model.BoardRemote
import com.editor.appcha.remote.model.CommentRemote
import java.time.LocalDateTime
import javax.inject.Inject

internal class BoardRemoteDataSourceImpl @Inject constructor(
    grpc: Grpc
) : BoardRemoteDataSource {

    override suspend fun getBoards(): Result<List<BoardData>> = Result.success(
        boards.map {
            it.toData()
        }
    )

    override suspend fun getBoard(boardId: String): Result<BoardData> =
        buildResult {
            BoardRemote(
                id = "0",
                title = "브랜디 에이블리 지그재그 쇼핑몰 중에 그나마 퀄리티 좋은 곳이 어디일까요? 추천좀",
                author = "우짤티비",
                commentCount = 1,
                body = "지그재그만 써봣는데 요새 블프기간이니까 다른곳들도 간볼려구여",
                createdAt = LocalDateTime.now(),
            )
        }.toData()

    override suspend fun getComments(boardId: String): Result<List<CommentData>> =
        buildResult { comments.toList().map { it.toData() } }

    override suspend fun postBoard(param: PostBoardData): Result<Unit> =
        Result.failure(UnsupportedOperationException())

    override suspend fun postComment(param: PostCommentData): Result<Unit> = buildResult {
        comments.add(
            CommentRemote(
                param.boardId,
                "테스트",
                text = param.text,
                createdAt = LocalDateTime.now()
            )
        )
    }
}

val comments = mutableListOf<CommentRemote>()

private val boards = listOf(
    BoardRemote(
        id = "1",
        title = "헐 인스타 디엠 읽으면 표시로 떠요?!",
        author = "각박한나쵸",
        commentCount = 3,
        body = "",
        createdAt = LocalDateTime.now(),
    ),
    BoardRemote(
        id = "2",
        title = "브랜디 에이블리 지그재그 쇼핑몰 중에 그나마 퀄리티 좋은 곳이 어디일까요? 추천좀",
        author = "우짤티비",
        commentCount = 1,
        body = "",
        createdAt = LocalDateTime.now(),
    ),
    BoardRemote(
        id = "3",
        title = "토스뱅크 캐시백을 토스뱅크 카드로 근처 동네 치킨집에서 사용하면 캐시백이 안들어오나요??",
        author = "닮은살걀",
        commentCount = 1,
        body = "",
        createdAt = LocalDateTime.now(),
    ),
    BoardRemote(
        id = "4",
        title = "식집사 있나요? 식물앱 추천들어갑니다",
        author = "체리쥬빌레",
        commentCount = 1,
        body = "",
        createdAt = LocalDateTime.now(),
    ),
    BoardRemote(
        id = "5",
        title = "무신사 생일쿠폰 언제 발급되는지 아세여?",
        author = "떡상무트코인",
        commentCount = 5,
        body = "",
        createdAt = LocalDateTime.now(),
    ),
    BoardRemote(
        id = "6",
        title = "소액으로 해외주식하기 좋은 미니스탁 앱 후기",
        author = "코인왕도지",
        commentCount = 1,
        body = "",
        createdAt = LocalDateTime.now(),
    ),
    BoardRemote(
        id = "7",
        title = "11번가 우주패스 아마존 직구하는거 보통 며칠이나 걸리나요?",
        author = "용쿠",
        commentCount = 9,
        body = "",
        createdAt = LocalDateTime.now(),
    ),
    BoardRemote(
        id = "8",
        title = "배민B마트 지금 주문하면 즉시 배달되는거에요? 아님 마켓컬리처럼 다음날 새벽배송인거에요? ",
        author = "illlijli",
        commentCount = 3,
        body = "",
        createdAt = LocalDateTime.now(),
    ),
)
