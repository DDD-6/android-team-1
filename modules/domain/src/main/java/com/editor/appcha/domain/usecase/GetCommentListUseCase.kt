package com.editor.appcha.domain.usecase

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.usecase.UseCase
import com.editor.appcha.domain.model.Comment
import com.editor.appcha.domain.repo.BoardRepository
import javax.inject.Inject

class GetCommentListUseCase @Inject constructor(
    private val repo: BoardRepository
) : UseCase<String, List<Comment>>() {

    /**
     * @param param boardId
     */
    override suspend fun execute(param: String): Result<List<Comment>> = repo.getComments(param)
}
