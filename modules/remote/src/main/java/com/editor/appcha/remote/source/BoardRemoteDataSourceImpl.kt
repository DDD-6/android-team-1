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
        List(20) {
            BoardRemote(
                id = "$it",
                title = "제목이 들어갑니다. 제목이 들어갑니다. 제목이 들어갑니다. 제목이 들어갑니다.",
                author = "닉네임",
                commentCount = 1,
                body = "",
                createdAt = LocalDateTime.now(),
            )
        }.map { it.toData() })

    override suspend fun getBoard(boardId: String): Result<BoardData> =
        buildResult {
            BoardRemote(
                id = "0",
                title = "제목이 들어갑니다. 제목이 들어갑니다. 제목이 들어갑니다. 제목이 들어갑니다.",
                author = "닉네임",
                commentCount = 1,
                body = "본문 내용이 들어갑니다.본문 내용이 들어갑니다.본문 내용이 들어갑니다.본문 내용이 들어갑니다.본문 내용이 들어갑니다.본문 내용이 들어갑니다.",
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
