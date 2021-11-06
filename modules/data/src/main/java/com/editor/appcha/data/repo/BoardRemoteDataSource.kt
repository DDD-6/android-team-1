package com.editor.appcha.data.repo

import com.editor.appcha.core.arch.Result
import com.editor.appcha.data.model.BoardData
import com.editor.appcha.data.model.CommentData
import com.editor.appcha.data.model.request.PostBoardData
import com.editor.appcha.data.model.request.PostCommentData
import com.editor.appcha.domain.model.Board

interface BoardRemoteDataSource {

    suspend fun getBoards(): Result<List<BoardData>>

    suspend fun getBoard(boardId: String): Result<Board>

    suspend fun getComments(boardId: String): Result<List<CommentData>>

    suspend fun postBoard(param: PostBoardData): Result<Unit>

    suspend fun postComment(param: PostCommentData): Result<Unit>
}
