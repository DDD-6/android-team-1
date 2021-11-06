package com.editor.appcha.domain.usecase

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.usecase.UseCase
import com.editor.appcha.domain.model.Board
import com.editor.appcha.domain.repo.BoardRepository
import javax.inject.Inject

class GetBoardsUseCase @Inject constructor(
    private val repo: BoardRepository
) : UseCase<Unit, List<Board>>() {

    override suspend fun execute(param: Unit): Result<List<Board>> = repo.getBoards()
}
