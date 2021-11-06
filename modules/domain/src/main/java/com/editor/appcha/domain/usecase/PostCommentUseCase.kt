package com.editor.appcha.domain.usecase

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.usecase.UseCase
import com.editor.appcha.domain.model.request.PostComment
import com.editor.appcha.domain.repo.BoardRepository
import javax.inject.Inject

class PostCommentUseCase @Inject constructor(
    private val repo: BoardRepository
) : UseCase<PostComment, Unit>() {

    override suspend fun execute(param: PostComment): Result<Unit> = repo.postComment(param)
}
