package com.editor.appcha.data.source

import com.editor.appcha.core.arch.Result
import com.editor.appcha.data.model.BoardData
import com.editor.appcha.data.model.CommentData
import com.editor.appcha.data.model.request.PostBoardData
import com.editor.appcha.data.model.request.PostCommentData

interface BoardRemoteDataSource {

    suspend fun getBoards(): Result<List<BoardData>>

    suspend fun getBoard(boardId: String): Result<BoardData>

    suspend fun getComments(boardId: String): Result<List<CommentData>>

    suspend fun postBoard(param: PostBoardData): Result<Unit>

    suspend fun postComment(param: PostCommentData): Result<Unit>
}
