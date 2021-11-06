package com.editor.appcha.data.repo

import com.editor.appcha.core.arch.Result
import com.editor.appcha.data.model.request.PostBoardData
import com.editor.appcha.data.model.request.PostCommentData
import com.editor.appcha.data.source.BoardRemoteDataSource
import com.editor.appcha.domain.model.Board
import com.editor.appcha.domain.model.Comment
import com.editor.appcha.domain.model.request.PostBoard
import com.editor.appcha.domain.model.request.PostComment
import com.editor.appcha.domain.repo.BoardRepository
import javax.inject.Inject

internal class BoardRepositoryImpl @Inject constructor(
    private val source: BoardRemoteDataSource
) : BoardRepository {

    override suspend fun getBoards(): Result<List<Board>> = source
        .getBoards()
        .map { data -> data.map { it.toDomain() } }

    override suspend fun getBoard(boardId: String): Result<Board> = source.getBoard(boardId)

    override suspend fun getComments(boardId: String): Result<List<Comment>> = source
        .getComments(boardId)
        .map { data -> data.map { it.toDomain() } }

    override suspend fun postBoard(param: PostBoard): Result<Unit> =
        source.postBoard(PostBoardData(param))

    override suspend fun postComment(param: PostComment): Result<Unit> =
        source.postComment(PostCommentData(param))
}
