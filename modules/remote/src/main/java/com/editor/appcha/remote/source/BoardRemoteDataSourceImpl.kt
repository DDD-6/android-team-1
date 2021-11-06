package com.editor.appcha.remote.source

import com.editor.appcha.core.arch.Result
import com.editor.appcha.data.model.BoardData
import com.editor.appcha.data.model.CommentData
import com.editor.appcha.data.model.request.PostBoardData
import com.editor.appcha.data.model.request.PostCommentData
import com.editor.appcha.data.source.BoardRemoteDataSource
import com.editor.appcha.remote.grpc.Grpc
import javax.inject.Inject

internal class BoardRemoteDataSourceImpl @Inject constructor(
    grpc: Grpc
) : BoardRemoteDataSource {

    override suspend fun getBoards(): Result<List<BoardData>> = Result.success(emptyList())

    override suspend fun getBoard(boardId: String): Result<BoardData> =
        Result.failure(UnsupportedOperationException())

    override suspend fun getComments(boardId: String): Result<List<CommentData>> =
        Result.failure(UnsupportedOperationException())

    override suspend fun postBoard(param: PostBoardData): Result<Unit> =
        Result.failure(UnsupportedOperationException())

    override suspend fun postComment(param: PostCommentData): Result<Unit> =
        Result.failure(UnsupportedOperationException())
}
