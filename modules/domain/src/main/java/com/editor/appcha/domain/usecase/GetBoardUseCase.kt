package com.editor.appcha.domain.usecase

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.usecase.UseCase
import com.editor.appcha.domain.model.Board
import com.editor.appcha.domain.repo.BoardRepository
import javax.inject.Inject

class GetBoardUseCase @Inject constructor(
    private val repo: BoardRepository
) : UseCase<String, Board>() {

    /**
     * @param param boardId
     */
    override suspend fun execute(param: String): Result<Board> = repo.getBoard(param)
}
