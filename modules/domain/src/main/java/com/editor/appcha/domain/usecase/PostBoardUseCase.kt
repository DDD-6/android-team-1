package com.editor.appcha.domain.usecase

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.usecase.UseCase
import com.editor.appcha.domain.model.request.PostBoard
import com.editor.appcha.domain.repo.BoardRepository
import javax.inject.Inject

class PostBoardUseCase @Inject constructor(
    private val repo: BoardRepository
) : UseCase<PostBoard, Unit>() {

    override suspend fun execute(param: PostBoard): Result<Unit> = repo.postBoard(param)
}
