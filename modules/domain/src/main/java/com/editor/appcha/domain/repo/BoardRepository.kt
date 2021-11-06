package com.editor.appcha.domain.repo

import com.editor.appcha.core.arch.Result
import com.editor.appcha.domain.model.Board
import com.editor.appcha.domain.model.Comment
import com.editor.appcha.domain.model.request.PostBoard
import com.editor.appcha.domain.model.request.PostComment

interface BoardRepository {

    suspend fun getBoards(): Result<List<Board>>

    suspend fun getBoard(boardId: String): Result<Board>

    suspend fun getComments(boardId: String): Result<List<Comment>>

    suspend fun postBoard(param: PostBoard): Result<Unit>

    suspend fun postComment(param: PostComment): Result<Unit>
}
